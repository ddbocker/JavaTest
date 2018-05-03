package com.cjh.cisdi.test.tinywebapplication.DataHandler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecordExample;

/**
 * 数据库流式处理类
 * 
 * @author cjh
 * 
 */
@Component
public class DataRecordResultHandler {

	@Autowired
	SqlSessionFactory sessionFactory;
	
	/**
	 * 数据分析结果集数组长度
	 */
	public final static int ANALYZE_RESULT_ARRAY_SIZE = 12;
	
	/**
	 * 计算样本标准差
	 * @param avgArr 平均值数组
	 * @param count 样本数
	 * @param param 条件map
	 * @param sqlSession 
	 * @param example
	 * @param mapperName
	 * @return
	 */
	public BigDecimal[] getSampleStd(BigDecimal[] avgArr, Integer count,  Map<String, Object> param,
			SqlSession sqlSession, String mapperName) {
		if (avgArr == null || count == null || count < 0 || param == null 
				|| sqlSession == null || StringUtils.isEmpty(mapperName)) {
			return null;
		}
		// 初始化求和数组
		final BigDecimal[] stdSumArr = new BigDecimal[ANALYZE_RESULT_ARRAY_SIZE];
		for (int i = 0; i < stdSumArr.length; i++) {
			stdSumArr[i] = BigDecimal.ZERO;
		}
		
		final BigDecimal[] avgFinal = avgArr;
		final Integer countFinal = count;
		// 标准差结果数组
		final BigDecimal[] stdArr = new BigDecimal[ANALYZE_RESULT_ARRAY_SIZE];
		// 流式处理
		sqlSession.select(mapperName, param, new ResultHandler<DataRecord>() {

			@Override
			public void handleResult(ResultContext<? extends DataRecord> resultContext) {
				DataRecord dataRecord = resultContext.getResultObject();
				BigDecimal[] dataArr = getBigDecimalArr(dataRecord);
				
				for (int i = 0; i < stdSumArr.length; i++) {
					// 当前列值
					BigDecimal columnValue = dataArr[i];
					// 当前列-平均值
					BigDecimal subtractValue = columnValue.subtract(avgFinal[i]);
					// 累加
					stdSumArr[i] = stdSumArr[i].add(subtractValue.multiply(subtractValue));
				}
				
				// 求标准差
				for (int i = 0; i < stdArr.length; i++) {
					// 去掉末尾0
					BigDecimal stdValue = stdSumArr[i].stripTrailingZeros();
					
					double sqrtValue = stdValue.divide(new BigDecimal(countFinal + ""), DataBiz.DATA_SCALE_NO, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().doubleValue();
					stdArr[i] = new BigDecimal(Math.sqrt(sqrtValue)).setScale(DataBiz.DATA_SCALE_NO, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
				}
			}
		});
		return stdArr;
	}
	
	/**
	 * 计算样本离散值
	 * @param avgArr 平均值结果集
	 * @param stdArr 标准差结果集
	 * @param param 条件map
	 * @param sqlSession
	 * @param example
	 * @param mapperName
	 * @return
	 */
	public int[] getSampleNs(BigDecimal[] avgArr, BigDecimal[] stdArr, Map<String, Object> param,
			SqlSession sqlSession, String mapperName) {
		if (avgArr == null || stdArr == null || param == null || 
				sqlSession == null || StringUtils.isEmpty(mapperName)) {
			return null;
		}
		
		// 初始化离群值结果集数组
		final int[] nsArr = new int[ANALYZE_RESULT_ARRAY_SIZE];
		for (int i = 0; i < nsArr.length; i++) {
			nsArr[i] = 0;
		}
		BigDecimal no = new BigDecimal(3 + "");
		// 计算范围
		final BigDecimal[] minArr = new BigDecimal[ANALYZE_RESULT_ARRAY_SIZE];
		final BigDecimal[] maxArr = new BigDecimal[ANALYZE_RESULT_ARRAY_SIZE];
		
		for (int i = 0; i < maxArr.length; i++) {
			minArr[i] = avgArr[i].subtract(stdArr[i].multiply(no));
			maxArr[i] = avgArr[i].add(stdArr[i].multiply(no));
		}
		
		// 流式处理
		sqlSession.select(mapperName, param, new ResultHandler<DataRecord>() {

			@Override
			public void handleResult(ResultContext<? extends DataRecord> resultContext) {
				DataRecord dataRecord = resultContext.getResultObject();
				BigDecimal[] dataArr = getBigDecimalArr(dataRecord);
				for (int i = 0; i < nsArr.length; i++) {
					// 当前列值
					BigDecimal currentValue = dataArr[i];
					if(currentValue.doubleValue() > maxArr[i].doubleValue() || currentValue.doubleValue() < minArr[i].doubleValue()) {
						nsArr[i] ++;
					}
				}
			}
		});
		return nsArr;
	}
	
	/**
	 * 对象转化为数组
	 * @param dataRecord
	 * @return
	 */
	public BigDecimal[] getBigDecimalArr(DataRecord dataRecord) {
		if(dataRecord == null) {
			return null;
		}
		BigDecimal[] dataArr = new BigDecimal[ANALYZE_RESULT_ARRAY_SIZE];
		dataArr[0] = dataRecord.getA1();
		dataArr[1] = dataRecord.getA2();
		dataArr[2] = dataRecord.getA3();
		dataArr[3] = dataRecord.getA4();
		dataArr[4] = dataRecord.getA5();
		dataArr[5] = dataRecord.getA6();
		dataArr[6] = dataRecord.getA7();
		dataArr[7] = dataRecord.getA8();
		dataArr[8] = dataRecord.getA9();
		dataArr[9] = dataRecord.getA10();
		dataArr[10] = dataRecord.getA11();
		dataArr[11] = dataRecord.getA12();
		return dataArr;
	}
}
