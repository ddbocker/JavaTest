package com.cjh.cisdi.test.tinywebapplication.common;

import java.util.List;

/**
 * 分页结果类
 * @author cjh
 *
 * @param <T>
 */
public class PageResult <T> {
	/**
     * 返回的数据结果集
     */
    private List<T> resultList;
    /**
     * 总数据条目
     */
    private Integer totalSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页
     */
    private Integer pageCurrent;
    /**
     * 显示的数据条目
     */
    private Integer pageSize;
    
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageResult [resultList=" + resultList + ", totalSize="
				+ totalSize + ", totalPage=" + totalPage + ", pageCurrent="
				+ pageCurrent + ", pageSize=" + pageSize + "]";
	}

}
