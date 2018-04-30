package com.cjh.cisdi.test.tinywebapplication.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;

/**
 * 自定义分页组件
 * 
 * @author cjh
 * 
 */
@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class}),
		@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class}) })
@Component
public class PageInterceptor implements Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

	public static final ThreadLocal<Page> localPage = new ThreadLocal<Page>();

	/**
	 * 开始分页
	 * 查询语句需以where条件结束，如果没有使用条件以where 1=1结束
	 * @param pageNum
	 * @param pageSize
	 * @param tableName 表名
	 * @param key 主键Id
	 * 
	 */
	public static void startPage(int pageNum, int pageSize, String tableName, String key) {
		localPage.set(new Page(pageNum, pageSize, tableName, key));
	}
	
	/**
     * 结束分页并返回结果，该方法必须被调用
     * @return
     */
    public static Page endPage() {
        Page page = localPage.get();
        localPage.remove();
        return page;
    }

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (localPage.get() == null) {
			return invocation.proceed();
		}
		
		if (invocation.getTarget() instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) invocation
					.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject
					.forObject(statementHandler);
			// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
			// 可以分离出最原始的的目标类)
			while (metaStatementHandler.hasGetter("h")) {
				Object object = metaStatementHandler.getValue("h");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}
			// 分离最后一个代理对象的目标类
			while (metaStatementHandler.hasGetter("target")) {
				Object object = metaStatementHandler.getValue("target");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");
			// 分页信息if (localPage.get() != null) {
			Page page = localPage.get();
			BoundSql boundSql = (BoundSql) metaStatementHandler
					.getValue("delegate.boundSql");
			// 分页参数作为参数对象parameterObject的一个属性
			String sql = boundSql.getSql();
			// 重写sql
			String pageSql = buildPageSql(sql, page);
			// 重写分页sql
			metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
			Connection connection = (Connection) invocation.getArgs()[0];
			// 重设分页参数里的总页数等
			setPageParameter(sql, connection, mappedStatement, boundSql, page);
			// 将执行权交给下一个拦截器
			return invocation.proceed();
		} else if (invocation.getTarget() instanceof ResultSetHandler) {
			Object result = invocation.proceed();
			Page page = localPage.get();
			page.setResult((List) result);
			return result;
		}
		return null;
	}

	/**
     * 只拦截这两种类型的
     * <br>StatementHandler
     * <br>ResultSetHandler
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub

	}
	
	 /**
     * 修改原SQL为分页SQL
     * @param sql
     * @param page
     * @return
     */
    private String buildPageSql(String sql, Page page) {
        StringBuilder pageSql = new StringBuilder(200);
        String beginrow = String.valueOf((page.getPageNum() - 1) * page.getPageSize());  
        pageSql.append(sql); 
        // 分页sql
        pageSql.append(" and id >= (SELECT " + page.getKey() + " FROM " + page.getTableName() + " LIMIT " + beginrow + ",1) LIMIT " +  page.getPageSize());
        return pageSql.toString();
    }

    /**
     * 获取总记录数
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
                                  BoundSql boundSql, Page page) {
        // 记录总记录数
        String countSql = "select count(0) from (" + sql + ") temporary";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            page.setTotal(totalCount);
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
            page.setPages(totalPage);
        } catch (SQLException e) {
            logger.error("Ignore this exception", e);
        } finally {
            try {
            	if(rs != null) {
            		rs.close();
            	}
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
            try {
            	if(countStmt != null) {
            		countStmt.close();
            	}
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
        }
    }

    /**
     * 代入参数值
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
                               Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }
	
    public static class Page<E> {
    	/**
    	 * 当前页码
    	 */
        private int pageNum;
        
        /**
         * 每页条数
         */
        private int pageSize;
        
        /**
         * 总条数
         */
        private long total;
        
        /**
         * 总页数
         */
        private int pages;
        
        /**
         * 数据集
         */
        private List<E> result;
        
        /**
         * 表名
         */
        private String tableName;
        
        /**
         * 主键名
         */
        private String key;

        public Page(int pageNum, int pageSize, String tableName, String key) {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.tableName = tableName;
            this.key = key;
        }

        public List<E> getResult() {
            return result;
        }

        public void setResult(List<E> result) {
            this.result = result;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize
					+ ", total=" + total + ", pages=" + pages + ", result="
					+ result + ", tableName=" + tableName + ", key=" + key
					+ "]";
		}
    }
}
