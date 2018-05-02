package com.cjh.cisdi.test.tinywebapplication;

import java.math.BigDecimal;
import java.util.List;

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
	public void testStdHandler(){
		BigDecimal[] avg = new BigDecimal[12];
		avg[0] = new BigDecimal("1.6244285714");
		avg[1] = new BigDecimal("90.4285714286");
		avg[2] = new BigDecimal("1275");
		avg[3] = new BigDecimal("12.7982857143");
		avg[4] = new BigDecimal("0.0205714286");
		avg[5] = new BigDecimal("10.9071428571");
		avg[6] = new BigDecimal("0.0292857143");
		avg[7] = new BigDecimal("0.0059285714");
		avg[8] = new BigDecimal("1008.4285714286");
		avg[9] = new BigDecimal("38153.4614285714");
		avg[10] = new BigDecimal("877.5");
		avg[11] = new BigDecimal("1128.7857142857");
		
		BigDecimal[] std = dataRecordResultHandler.getSampleStd(avg, 14, 3);
		Assert.assertTrue(std.length > 0);
	}
	
	@Test
	public void testNsHandler() {
		BigDecimal[] avg = new BigDecimal[12];
		avg[0] = new BigDecimal("1.6244285714");
		avg[1] = new BigDecimal("90.4285714286");
		avg[2] = new BigDecimal("1275");
		avg[3] = new BigDecimal("12.7982857143");
		avg[4] = new BigDecimal("0.0205714286");
		avg[5] = new BigDecimal("10.9071428571");
		avg[6] = new BigDecimal("0.0292857143");
		avg[7] = new BigDecimal("0.0059285714");
		avg[8] = new BigDecimal("1008.4285714286");
		avg[9] = new BigDecimal("38153.4614285714");
		avg[10] = new BigDecimal("877.5");
		avg[11] = new BigDecimal("1128.7857142857");
		
		BigDecimal[] std = dataRecordResultHandler.getSampleStd(avg, 14, 4);
		
		int[] ns = dataRecordResultHandler.getSampleNs(avg, std, 4);
		Assert.assertTrue(std.length > 0);
	}
	
	@Test
	public void testAvgHandler() {
		DataRecord avgDataRecord = dataRecordMapperExt.getSampleAvg(9);
		BigDecimal[] avg = dataRecordResultHandler.getBigDecimalArr(avgDataRecord);
		Assert.assertTrue(avg.length > 0);
	}
}
