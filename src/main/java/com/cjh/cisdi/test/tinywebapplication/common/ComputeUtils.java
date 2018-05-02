package com.cjh.cisdi.test.tinywebapplication.common;

import java.io.IOException;
import java.math.BigDecimal;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.csvreader.CsvReader;

/**
 * 计算帮助类
 * 
 * @author cjh
 * 
 */
public class ComputeUtils {
	/**
	 * 根据文件计算标准差
	 * @param avg 样本平均值
	 * @param csvReader
	 * @param count 样本个数
	 * @return
	 * @throws IOException 
	 */
	public static BigDecimal[] getSampleStd(BigDecimal[] avg, CsvReader csvReader,int count) throws IOException {
		if(avg == null || csvReader == null) {
			return null;
		}
		// 读取头
		csvReader.readHeaders();
		// 初始化求和数组
		BigDecimal[] stdSumArr = new BigDecimal[avg.length];
		for (int i = 0; i < stdSumArr.length; i++) {
			stdSumArr[i] = BigDecimal.ZERO;
		}
		
		while (csvReader.readRecord()) {
			for (int i = 0; i < stdSumArr.length; i++) {
				// 当前列值
				BigDecimal columnValue = new BigDecimal(csvReader.get(i));
				// 当前列-平均值
				BigDecimal subtractValue = columnValue.subtract(avg[i]);
				// 累加
				stdSumArr[i] = stdSumArr[i].add(subtractValue.multiply(subtractValue));
			}
		}
		// 求标准差
		BigDecimal[] stdArr = new BigDecimal[avg.length];
		for (int i = 0; i < stdArr.length; i++) {
			// 去掉末尾0
			BigDecimal stdValue = stdSumArr[i].stripTrailingZeros();
			
			double sqrtValue = stdValue.divide(new BigDecimal(count + ""), DataBiz.DATA_SCALE_NO, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().doubleValue();
			stdArr[i] = new BigDecimal(Math.sqrt(sqrtValue)).setScale(DataBiz.DATA_SCALE_NO, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
		}
		return stdArr;
	}
	
	/**
	 * 根据文件计算样本离群值
	 * @param avg
	 * @param std
	 * @return
	 * @throws IOException 
	 */
	public static int[] getSampleNs(BigDecimal[] avg, BigDecimal[] std, CsvReader csvReader) throws IOException {
		if(avg == null || csvReader == null || std == null) {
			return null;
		}
		// 读取头
		csvReader.readHeaders();
		// 初始化离群值数组
		int[] nsArr = new int[avg.length];
		for (int i = 0; i < nsArr.length; i++) {
			nsArr[i] = 0;
		}
		
		BigDecimal no = new BigDecimal(3 + "");
		// 计算范围
		BigDecimal[] minArr = new BigDecimal[avg.length];
		BigDecimal[] maxArr = new BigDecimal[avg.length];
		
		for (int i = 0; i < maxArr.length; i++) {
			minArr[i] = avg[i].subtract(std[i].multiply(no));
			maxArr[i] = avg[i].add(std[i].multiply(no));
		}
		
		while (csvReader.readRecord()) {
			for (int i = 0; i < nsArr.length; i++) {
				// 当前列值
				BigDecimal currentValue = new BigDecimal(csvReader.get(i));
				if(currentValue.doubleValue() > maxArr[i].doubleValue() || currentValue.doubleValue() < minArr[i].doubleValue()) {
					nsArr[i] ++;
				}
			}
		}
		return nsArr;
	}
	
	
}
