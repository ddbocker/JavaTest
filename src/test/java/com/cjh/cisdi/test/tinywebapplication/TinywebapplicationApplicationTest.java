package com.cjh.cisdi.test.tinywebapplication;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjh.cisdi.test.tinywebapplication.DataHandler.DataRecordResultHandler;
import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.ExcelUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecordExample;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;
import com.cjh.cisdi.test.tinywebapplication.service.DataService;

/**
 * 
 * @author cjh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TinywebapplicationApplicationTest {
	@Autowired
	DataBiz dataBiz;
	@Autowired
	DataRecordMapperExt dataRecordMapperExt;
	@Autowired
	DataFileMapper dataFileMapper;
	@Autowired
	DataRecordMapper dataRecordMapper;
	@Autowired
	DataService dataService;
	@Autowired
	DataRecordResultHandler dataRecordResultHandler;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void readExcelTest() {
		String filePath = "C://test//1524706745957.xlsx";
		List<DataRecord> dataRecords = ExcelUtils.getDataListFromExcel(filePath);
		Assert.assertNotNull(dataRecords);
	}
	
	@Test
	public void insert() {
		String filePath = "C://test//1524706745957.xlsx";
		List<DataRecord> dataRecords = ExcelUtils.getDataListFromExcel(filePath);
		int rel = dataBiz.dataPersistence(dataRecords);
		Assert.assertTrue(rel > 0);
	}
	
	/**
	 * 分页获取
	 */
	@Test
	public void testPage() {
		//页码，每页记录数默认为50
		Integer pageNo = 1;
		Integer fileId = 1;
		Page<DataRecord> rel = dataService.getDataRecordPageResult(fileId,pageNo);
		Assert.assertNotNull(rel);
	}
	
	@Test
	public void testPageInsert() {
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(14);
		int rel = dataBiz.dataPersistence(dataFile);
		Assert.assertTrue(rel > 0);
	}
	
	
	@Test
	public void testNsHandler() {
		Integer fileId = 11;
		// 获取样本平均值
		DataRecord avgDataRecord = dataRecordMapperExt.getSampleAvg(fileId);
		// 因子数
		int factorNum = Integer.valueOf(avgDataRecord.getQuality());
		// 转换为数组
		BigDecimal[] avg = dataRecordResultHandler.getBigDecimalArr(avgDataRecord);			
		
		SqlSession sqlSession = sqlSessionFactory.openSession();			
		DataRecordExample example = new DataRecordExample();
		DataRecordExample.Criteria criteria = example.createCriteria();
		criteria.andFileRecordidEqualTo(4);
		
		Map<String, Object> param = new HashMap<String, Object>();
		//param.put("oredCriteria", example.getOredCriteria());
		param.put("fileId", 10);
		//String mapperName = "com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper.selectByExample";
		
		String mapperName = "com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt.getDataRecords";
		
		BigDecimal[] std = dataRecordResultHandler.getSampleStd(avg, 14, param, sqlSession, mapperName);
		
		int[] ns = dataRecordResultHandler.getSampleNs(avg, std, param, sqlSession, mapperName);
		sqlSession.close();
		Assert.assertTrue(ns.length > 0);
	}
	
	@Test
	public void testAvgHandler() {
		DataRecord avgDataRecord = dataRecordMapperExt.getSampleAvg(9);
		BigDecimal[] avg = dataRecordResultHandler.getBigDecimalArr(avgDataRecord);
		Assert.assertTrue(avg.length > 0);
	}
}
