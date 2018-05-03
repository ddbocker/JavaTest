package com.cjh.cisdi.test.tinywebapplication.biz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cjh.cisdi.test.tinywebapplication.DataHandler.DataRecordResultHandler;
import com.cjh.cisdi.test.tinywebapplication.common.BusinessException;
import com.cjh.cisdi.test.tinywebapplication.common.ConfigBean;
import com.cjh.cisdi.test.tinywebapplication.common.CsvUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyze;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.enums.AnalyzeTypeEnum;
import com.cjh.cisdi.test.tinywebapplication.enums.FileStatusTypeEnum;
import com.cjh.cisdi.test.tinywebapplication.enums.FileTypeEnum;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataAnalyzeMapperExt;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapperExt;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;
import com.cjh.cisdi.test.tinywebapplication.service.DataServiceImpl;
import com.csvreader.CsvReader;

/**
 * 数据业务处理类
 * @author cjh
 *
 */
@Component
public class DataBiz {
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class); 
	
	/**
	 * 默认页码
	 */
	private static final Integer DEFAULT_PAGE_CURRENT = 1;
	
	/**
	 * 每页获取条数
	 */
    private static final Integer DEFAULT_PAGE_SIZE = 50;
    
    /**
     * 文件列数
     */
    private static final Integer COLUMN_SIZE = 13;
    
    /**
     * 每次插入数据行数
     */
    public static final Integer INSERT_SIZE = 1000;
    
    /**
     * 分析数据保留位数
     */
    public static final Integer DATA_SCALE_NO = 10;
    
    @Autowired
	DataRecordMapperExt dataRecordMapperExt;
	
	@Autowired
	DataRecordMapper dataRecordMapper;
	
	@Autowired
	ConfigBean configBean;
	
	@Autowired
	DataFileMapperExt dataFileMapperExt;
	
	@Autowired
	DataFileMapper dataFileMapper;
	
	@Autowired
	DataAnalyzeMapperExt dataAnalyzeMapperExt;
	
	@Autowired
	DataRecordResultHandler dataRecordResultHandler;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
    /**
     * 批量写入数据库
     * @param dataList
     * @param dataFileId 文件记录id
     * @return
     */
	public int dataPersistence(List<DataRecord> dataList) {
		return dataRecordMapperExt.insert(dataList);
	}
	
	/**
	 * 处理队列数据，分批写入数据库
	 * @param dataFile 上传文件记录
	 * @return
	 */
	@Transactional(rollbackFor={Exception.class,RuntimeException.class})
	public int dataPersistence(DataFile dataFile) {
		// 判断文件类型，csv文件处理
		if(dataFile.getFiletype() != null && !FileTypeEnum.TYPE_CSV.getCode().equals(dataFile.getFiletype().toLowerCase())) {
			throw new BusinessException("文件类型有误");
		} 
		csvDataListProcces(dataFile);
		return 1;
	}
	
	/**
	 * 分页获取数据
	 * @param fileId 文件记录Id
	 * @param page 当前页码
	 * @return
	 */
	public Page<DataRecord> getDataRecordPageResult(Integer fileId, Integer page) {
		if(page == null || page == 0) {
			page = DEFAULT_PAGE_CURRENT;
		}
		PageInterceptor.startPage(page, DEFAULT_PAGE_SIZE, "data_record", "id");
		dataRecordMapperExt.getDataRecordsByPage(fileId);
		return PageInterceptor.endPage();
	}
	
	/**
	 * xlsx文件处理
	 * @param dataFile
	 * @deprecated
	 */
	private void xlsxDataListProcces(DataFile dataFile) {
		List<DataRecord> dataList = new ArrayList<DataRecord>(DataBiz.INSERT_SIZE);
		
		String filePath = dataFile.getFilepath() + dataFile.getNewfilename();
		
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
				dataRecord.setFileRecordid(dataFile.getId());
				dataList.add(dataRecord);
				// 分段插入数据
				if(dataList.size() == DataBiz.INSERT_SIZE) {
					if(dataPersistence(dataList) < 1) {
			        	logger.error(filePath + "datarecord insert fail");
			        	throw new BusinessException("文件数据写入数据库失败");
			        }
					dataList = new ArrayList<DataRecord>(DataBiz.INSERT_SIZE);
				}
			}
			// 将剩余数据写入数据库
			if(dataPersistence(dataList) < 1) {
	        	logger.error(filePath + "datarecord insert fail");
	        	throw new BusinessException("文件数据写入数据库失败");
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
	}
	
	/**
	 * csv文件处理
	 * @param dataFile
	 */
	private void csvDataListProcces(DataFile dataFile) {
		List<DataRecord> dataList = new ArrayList<DataRecord>(DataBiz.INSERT_SIZE);
		
		String filePath = dataFile.getFilepath() + dataFile.getNewfilename();
		// 读取文件
		CsvReader csvReader = null;
		
		// 计数器
		int count = 0;
		
		SqlSession sqlSession = null;
		try {
			csvReader = new CsvReader(filePath);
			
			// 保存列名的数组
            String[] columnNameArr =  new String[COLUMN_SIZE];
            
            // 保存数字列和的数组
         	BigDecimal[] columnSumArr = new BigDecimal[COLUMN_SIZE - 1];
         	
         	// 保存字符串的set
         	Set<String> columnNsSet = new HashSet<>();
			// 读表头
			if(csvReader.readHeaders()) {
				for (int i = 0; i < COLUMN_SIZE; i++) {
					columnNameArr[i] = csvReader.getHeader(i);
					if(i == COLUMN_SIZE - 1) {
						continue;
					}
					// 初始化求和数组值
					columnSumArr[i] = BigDecimal.ZERO;
				}
			}
			
			while (csvReader.readRecord()) {
				count++;
				// 累加
				for (int i = 0; i < columnSumArr.length; i++) {
					columnSumArr[i] = columnSumArr[i].add(new BigDecimal(csvReader.get(i)));
				}
				// 字符放入集合
				columnNsSet.add(csvReader.get(12));
			    // 构建对象
				dataList.add(initDataRecord(csvReader, dataFile.getId()));
				// 分段插入数据
				if(dataList.size() == DataBiz.INSERT_SIZE) {
					if(dataPersistence(dataList) < 1) {
			        	logger.error(filePath + "datarecord insert fail");
			        	throw new BusinessException("文件数据写入数据库失败");
			        }
					dataList = new ArrayList<DataRecord>(DataBiz.INSERT_SIZE);
				}
				// 分段放入队列，再由消费者写入数据库
				/*if(dataList.size() == DataBiz.INSERT_SIZE) {
					DataHanlder.DATALIST_FILE_QUEUE.offer(dataList);
					dataList = new ArrayList<DataRecord>(DataBiz.INSERT_SIZE); 
				}*/
			}
			// 将剩余数据写入数据库
			if(dataPersistence(dataList) < 1) {
	        	logger.error(filePath + "datarecord insert fail");
	        	throw new BusinessException("文件数据写入数据库失败");
	        }
			logger.info("analyze data begin:" + System.currentTimeMillis());
			
			/*
			// 计算平均值
			BigDecimal[] avgArr = new BigDecimal[columnSumArr.length];
			for (int i = 0; i < avgArr.length; i++) {
				avgArr[i] = columnSumArr[i].divide(new BigDecimal(count + ""), DATA_SCALE_NO, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
			}
			// 计算标准差
			BigDecimal[] stdArr = ComputeUtils.getSampleStd(avgArr, new CsvReader(filePath), count);
			
			// 计算离群值
			int[] nsArr = ComputeUtils.getSampleNs(avgArr, stdArr, new CsvReader(filePath));
			
			// 计算因子数
			int factorNum = columnNsSet.size();
			*/
			
			
			// 获取样本平均值
			DataRecord avgDataRecord = dataRecordMapperExt.getSampleAvg(dataFile.getId());
			if(avgDataRecord == null) {
				logger.error(filePath + "从数据库获取数值列平均值失败");
	        	throw new BusinessException(filePath + "从数据库获取数值列平均值失败");
			}
			// 因子数
			int factorNum = Integer.valueOf(avgDataRecord.getQuality());
			// 转换为数组
			BigDecimal[] avgArr = dataRecordResultHandler.getBigDecimalArr(avgDataRecord);
			
			// 使用流式遍历数据详情记录
			sqlSession = sqlSessionFactory.openSession();			
			
			// 条件查询
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("fileId", dataFile.getId());
			String mapperName = "com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt.getDataRecords";
			
			// 获取标准差结果集
			BigDecimal[] stdArr = dataRecordResultHandler.getSampleStd(avgArr, count, param, sqlSession, mapperName);
			
			if(stdArr == null) {
				logger.error(filePath + "计算标准差异常");
	        	throw new BusinessException(filePath + "计算标准差异常");
			}
			
			// 获取离群值结果集
			int[] nsArr = dataRecordResultHandler.getSampleNs(avgArr, stdArr, param, sqlSession, mapperName);
			
			if(nsArr == null) {
				logger.error(filePath + "计算离群值异常");
	        	throw new BusinessException(filePath + "计算离群值异常");
			}
			
			// 构建分析记录列表
			List<DataAnalyze> dataAnalyzes = new ArrayList<>(columnNameArr.length);
			for (int i = 0; i < columnNameArr.length; i++) {
				DataAnalyze dataAnalyze = new DataAnalyze();
				dataAnalyze.setFileRecordid(dataFile.getId());
				// 列名
				dataAnalyze.setColumnName(columnNameArr[i]);
				// 数字列
				if(i < columnNameArr.length - 1) {
					dataAnalyze.setColumnType(AnalyzeTypeEnum.TYPE_NUM.getCode());
					dataAnalyze.setAvg(avgArr[i]);
					dataAnalyze.setStd(stdArr[i]);
					dataAnalyze.setNs(nsArr[i]);
					dataAnalyzes.add(dataAnalyze);
					continue;
				} 
				// 字符列
				dataAnalyze.setColumnType(AnalyzeTypeEnum.TYPE_CHAR.getCode());
				dataAnalyze.setFactor(factorNum);
				dataAnalyzes.add(dataAnalyze);
			}
			
			// 写入分析数据记录
			if(dataAnalyzeMapperExt.insert(dataAnalyzes) < 1) {
				logger.error(filePath + "dataAnalyzes insert fail");
	        	throw new BusinessException("分析数据写入数据库失败");
			};
			logger.info("analyze data end:" + System.currentTimeMillis());
			// 标记文件处理成功
			DataFile updateDataFile = new DataFile();
			updateDataFile.setId(dataFile.getId());
			updateDataFile.setStatus(FileStatusTypeEnum.TYPE_SUCCESS.getCode());
			if(updateDataFileRecord(updateDataFile) < 1) {
				logger.error(filePath + "dataAnalyzes update fail");
	        	throw new BusinessException("更新上传文件记录状态失败");
			};
		} catch (NumberFormatException numberFormatException) {
			// 处理转换失败异常
			String logString = "file　`" +dataFile.getFilename() + "` numberFormat exception at line " + (count + 1);
			logger.error(logString,numberFormatException);
			// 标注文件记录处理失败，并记录信息
			DataFile updateDataFile = new DataFile();
			updateDataFile.setId(dataFile.getId());
			updateDataFile.setStatus(FileStatusTypeEnum.TYPE_FAILED.getCode());
			updateDataFile.setData(logString);
			updateDataFileRecord(updateDataFile);
		} catch (IOException e) {
			logger.error("csv file read fail",e);
			// 标注文件记录处理失败，并记录信息
			DataFile updateDataFile = new DataFile();
			updateDataFile.setId(dataFile.getId());
			updateDataFile.setStatus(FileStatusTypeEnum.TYPE_FAILED.getCode());
			updateDataFile.setData("file　`" +dataFile.getFilename() +"read fail");
			updateDataFileRecord(updateDataFile);
		} finally {
			if(csvReader != null) {
				csvReader.close();
			}
			
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 初始化DataRecord对象
	 * @param csvReader
	 * @param dataFileId
	 * @return
	 * @throws IOException 
	 */
	private DataRecord initDataRecord(CsvReader csvReader,Integer dataFileId) throws IOException {
		DataRecord dataRecord = new DataRecord();
		dataRecord.setA1(new BigDecimal(csvReader.get(0)));
		dataRecord.setA2(new BigDecimal(csvReader.get(1)));
		dataRecord.setA3(new BigDecimal(csvReader.get(2)));
		dataRecord.setA4(new BigDecimal(csvReader.get(3)));
		dataRecord.setA5(new BigDecimal(csvReader.get(4)));
		dataRecord.setA6(new BigDecimal(csvReader.get(5)));
		dataRecord.setA7(new BigDecimal(csvReader.get(6)));
		dataRecord.setA8(new BigDecimal(csvReader.get(7)));
		dataRecord.setA9(new BigDecimal(csvReader.get(8)));
		dataRecord.setA10(new BigDecimal(csvReader.get(9)));
		dataRecord.setA11(new BigDecimal(csvReader.get(10)));
		dataRecord.setA12(new BigDecimal(csvReader.get(11)));
		dataRecord.setQuality(csvReader.get(12));
		dataRecord.setFileRecordid(dataFileId);
		return dataRecord;
	}
	
	/**
	 * 更新csv文件单元格
	 * @param dataFileId 文件记录id,data_file表记录
	 * @param rowNum 行号
	 * @param columnNum 列号
	 * @param value 修改值
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean updateCsvFile(Integer dataFileId,Integer rowNum,Integer columnNum,String value) {
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		if(dataFile == null) {
			return false;
		}
		// mysql乐观锁
		dataFileUpdatelock(dataFile.getId());
		return CsvUtils.updateCsvFile(rowNum, columnNum, value, dataFile);
	}
	
	/**
	 * 删除csv某行记录
	 * @param dataFileId
	 * @param rowNum
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean deleteCsvFileForRow(Integer dataFileId,Integer rowNum) {
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		if(dataFile == null) {
			return false;
		}
		// mysql乐观锁
		dataFileUpdatelock(dataFile.getId());
		return  CsvUtils.deleteCsvFileForRow(rowNum, dataFile);
	}
	
	/**
	 * 删除csv某列记录
	 * @param dataFileId
	 * @param columnNum
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean deleteCsvFileForColumn(Integer dataFileId,Integer columnNum) {
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		if(dataFile == null) {
			return false;
		}
		// mysql乐观锁
		dataFileUpdatelock(dataFile.getId());
		return  CsvUtils.deleteCsvFileForColumn(columnNum, dataFile);
	}
	
	/**
	 * @param id data_file主键
	 * 乐观锁
	 */
	private void dataFileUpdatelock(Integer id) {
		DataFile updateDataFile = new DataFile();
		updateDataFile.setId(id);
		updateDataFile.setUpdatetime(new Date());
		dataFileMapper.updateByPrimaryKeySelective(updateDataFile);
	}
	
	/**
	 * 条件更新文件上传记录
	 * @param dataFile
	 * @return
	 */
	public int updateDataFileRecord(DataFile dataFile) {
		return dataFileMapper.updateByPrimaryKeySelective(dataFile);
	}	
}
