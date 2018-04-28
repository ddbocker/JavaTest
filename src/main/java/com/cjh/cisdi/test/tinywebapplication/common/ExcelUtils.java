package com.cjh.cisdi.test.tinywebapplication.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;

/**
 * Excel帮助类
 * 
 * @author cjh
 * 
 */
public class ExcelUtils {
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
	
	
	/**
	 * 获取excel文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static XSSFWorkbook getExcelFile(String filePath) {
		// 判断是否为空
		if (StringUtils.isEmpty(filePath)) {
			return null;
		}
		try {
			// 读取文件
			InputStream is = new FileInputStream(filePath);
			return new XSSFWorkbook(is);
		} catch (FileNotFoundException e) {
			logger.error("find " + filePath + "fail", e);
			throw new BusinessException("未找到对应文件");
		} catch (IOException e) {
			logger.error("read " + filePath + "fail", e);
			throw new BusinessException("读取文件内容失败");
		}
	}
	
	/**
	 * 将分页获取Excel文件数据转换成List
	 * 
	 * @param wb 
	 * @param beginRow 开始行号
	 * @param endRow 结束行号
	 * @return
	 */
	public static List<DataRecord> getDataListFromExcel(XSSFWorkbook wb,Integer beginRow,Integer endRow) {
		// 判断是否为空
		if (wb == null) {
			return null;
		}
		List<DataRecord> dataList = new ArrayList<DataRecord>();
		// 读取文件
		XSSFSheet sheet = wb.getSheetAt(0);
		// 遍历文件，存入List，排查列名
		for (int i = beginRow; i <= endRow; i++) {
			Row row = sheet.getRow(i);
			DataRecord dataRecord = new DataRecord();
			dataRecord.setA1(BigDecimal.valueOf(row.getCell(0).getNumericCellValue()));
			dataRecord.setA2(BigDecimal.valueOf(row.getCell(1).getNumericCellValue()));
			dataRecord.setA3(BigDecimal.valueOf(row.getCell(2).getNumericCellValue()));
			dataRecord.setA4(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()));
			dataRecord.setA5(BigDecimal.valueOf(row.getCell(4).getNumericCellValue()));
			dataRecord.setA6(BigDecimal.valueOf(row.getCell(5).getNumericCellValue()));
			dataRecord.setA7(BigDecimal.valueOf(row.getCell(6).getNumericCellValue()));
			dataRecord.setA8(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()));
			dataRecord.setA9(BigDecimal.valueOf(row.getCell(8).getNumericCellValue()));
			dataRecord.setA10(BigDecimal.valueOf(row.getCell(9).getNumericCellValue()));
			dataRecord.setA11(BigDecimal.valueOf(row.getCell(10).getNumericCellValue()));
			dataRecord.setA12(BigDecimal.valueOf(row.getCell(11).getNumericCellValue()));
			dataRecord.setQuality(row.getCell(12).getStringCellValue());
			dataList.add(dataRecord); 
		}			
		return dataList;
	}
	
	/**
	 * 将Excel文件数据转换成List
	 * 
	 * @param filePath
	 * @return
	 */
	public static List<DataRecord> getDataListFromExcel(String filePath) {
		// 判断是否为空
		if (StringUtils.isEmpty(filePath)) {
			return null;
		}
		List<DataRecord> dataList = new ArrayList<DataRecord>();
		XSSFWorkbook wb = null;
		try {
			// 读取文件
			InputStream is = new FileInputStream(filePath);
			wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(0);
			// 遍历文件，存入List，排查列名
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				DataRecord dataRecord = new DataRecord();
				dataRecord.setA1(BigDecimal.valueOf(row.getCell(0).getNumericCellValue()));
				dataRecord.setA2(BigDecimal.valueOf(row.getCell(1).getNumericCellValue()));
				dataRecord.setA3(BigDecimal.valueOf(row.getCell(2).getNumericCellValue()));
				dataRecord.setA4(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()));
				dataRecord.setA5(BigDecimal.valueOf(row.getCell(4).getNumericCellValue()));
				dataRecord.setA6(BigDecimal.valueOf(row.getCell(5).getNumericCellValue()));
				dataRecord.setA7(BigDecimal.valueOf(row.getCell(6).getNumericCellValue()));
				dataRecord.setA8(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()));
				dataRecord.setA9(BigDecimal.valueOf(row.getCell(8).getNumericCellValue()));
				dataRecord.setA10(BigDecimal.valueOf(row.getCell(9).getNumericCellValue()));
				dataRecord.setA11(BigDecimal.valueOf(row.getCell(10).getNumericCellValue()));
				dataRecord.setA12(BigDecimal.valueOf(row.getCell(11).getNumericCellValue()));
				dataRecord.setQuality(row.getCell(12).getStringCellValue());
				dataList.add(dataRecord);
			}
		} catch (FileNotFoundException e) {
			logger.error("find " + filePath + "fail", e);
			throw new BusinessException("未找到对应文件");
		} catch (IOException e) {
			logger.error("read " + filePath + "fail", e);
			throw new BusinessException("读取文件内容失败");
		}finally {
			if(wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					logger.error("XSSFWorkbook close fail", e);
				}
			}
		}
		return dataList;
	}
	
	/**
	 * 获取excel数据行数
	 * 
	 * @param wb
	 * @return
	 */
	public static Integer getFileRows(XSSFWorkbook wb) {
		// 判断是否为空
		if (wb == null) {
			return null;
		}
		// 读取文件行数
		XSSFSheet sheet = wb.getSheetAt(0);
		return sheet.getLastRowNum();
	}
}
