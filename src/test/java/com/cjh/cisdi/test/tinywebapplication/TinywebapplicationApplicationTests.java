package com.cjh.cisdi.test.tinywebapplication;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.CsvUtils;
import com.cjh.cisdi.test.tinywebapplication.common.ExcelUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinywebapplicationApplicationTests {
	@Autowired
	DataBiz dataBiz;
	@Autowired
	DataRecordMapperExt dataRecordMapperExt;
	@Autowired
	DataFileMapper dataFileMapper;
	@Autowired
	DataRecordMapper dataRecordMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(TinywebapplicationApplicationTests.class);
	
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
	public void test_page() {
		//页码，每页记录数默认为50
		Integer pageNo = 5;
		Integer fileId = 1;
		Page<DataRecord> rel = dataBiz.getDataRecordPageResult(fileId,pageNo);
		Assert.assertNotNull(rel);
	}
	
	@Test
	public void test_pageInsert() {
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(14);
		int rel = dataBiz.dataPersistence(dataFile);
		Assert.assertTrue(rel > 0);
	}
	
	/**
	 * 修改单元格
	 */
	@Test
	public void test_updateCsvFile() {
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 14;
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		//修改文件第二行，第二列数据为123
		boolean rel = CsvUtils.updateCsvFile(2, 2, "1223", dataFile);
		Assert.assertTrue(rel);
	}
	
	/**
	 * 删除某行
	 */
	@Test
	public void test_deleteRowCsvFile() {
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 1;
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		//删除文件第二行
		boolean rel = CsvUtils.deleteCsvFileForRow(2, dataFile);
		Assert.assertTrue(rel);
	}
	
	/**
	 * 删除某列
	 */
	@Test
	public void test_deleteColCsvFile() {
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 1;
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		//删除文件第一列
		boolean rel = CsvUtils.deleteCsvFileForColumn(1, dataFile);
		Assert.assertTrue(rel);
	}
	
	/**
	 * 并发更新
	 */
	@Test
	public void test_concurrentUpdate() {
		// 并发线程数
		int count = 6;
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 1;
		ExecutorService executorService = new ThreadPoolExecutor(count, count, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		final CountDownLatch countDownLatch = new CountDownLatch(count); 
		final CountDownLatch countDownLatch2 = new CountDownLatch(count);
		try {
			for (int i = 0; i < count; i++) {
				final int  no = i +1;
				executorService.execute(new Runnable() {
					
					@Override
					public void run() {
						try {
							countDownLatch2.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						dataBiz.updateCsvFile(dataFileId, no, no, no + "");
						countDownLatch.countDown();
					}
				});
				countDownLatch2.countDown();
			}
			
			countDownLatch.await();
	        executorService.shutdown();//关闭线程池
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
