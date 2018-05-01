package com.cjh.cisdi.test.tinywebapplication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.CsvUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;

/**
 * 文件修改测试
 * @author cjh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvFileProcessTest {
	@Autowired
	DataBiz dataBiz;
	@Autowired
	DataRecordMapperExt dataRecordMapperExt;
	@Autowired
	DataFileMapper dataFileMapper;
	@Autowired
	DataRecordMapper dataRecordMapper;
	
	/**
	 * 修改单元格
	 */
	@Test
	public void testUpdateCsvFile() {
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 7;
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		//修改文件第二行，第一列数据为1223
		boolean rel = CsvUtils.updateCsvFile(2, 1, "1223", dataFile);
		Assert.assertTrue(rel);
	}
	
	/**
	 * 删除某行
	 */
	@Test
	public void testDeleteRowCsvFile() {
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 7;
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		//删除文件第二行
		boolean rel = CsvUtils.deleteCsvFileForRow(2, dataFile);
		Assert.assertTrue(rel);
	}
	
	/**
	 * 删除某列
	 */
	@Test
	public void testDeleteColCsvFile() {
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 7;
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(dataFileId);
		//删除文件第一列
		boolean rel = CsvUtils.deleteCsvFileForColumn(1, dataFile);
		Assert.assertTrue(rel);
	}
	
	/**
	 * 并发更新
	 */
	@Test
	public void testConcurrentUpdate() {
		// 并发线程数
		int count = 6;
		// 上传文件记录主键id，data_fileid，需修改为对应记录再测试;
		final int dataFileId = 7;
		ExecutorService executorService = new ThreadPoolExecutor(count, count, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		// 结束计数器
		final CountDownLatch countDownLatch = new CountDownLatch(count); 
		// 启动计数器
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
