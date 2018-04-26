package com.cjh.cisdi.test.tinywebapplication;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.ExcelUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;
import com.cjh.cisdi.test.tinywebapplication.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinywebapplicationApplicationTests {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	DataBiz dataBiz;
	@Autowired
	DataRecordMapperExt dataRecordMapperExt;
	
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
}
