package com.cjh.cisdi.test.tinywebapplication;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.ExcelUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;

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
	
	private static final Logger logger = LoggerFactory.getLogger(TinywebapplicationApplicationTest.class);
	
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
		Integer pageNo = 5;
		Integer fileId = 1;
		Page<DataRecord> rel = dataBiz.getDataRecordPageResult(fileId,pageNo);
		Assert.assertNotNull(rel);
	}
	
	@Test
	public void testPageInsert() {
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(14);
		int rel = dataBiz.dataPersistence(dataFile);
		Assert.assertTrue(rel > 0);
	}
}
