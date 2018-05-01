package com.cjh.cisdi.test.tinywebapplication.common;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;

/**
 * 队列消费者
 * @author cjh
 *
 */
@Component
public class DataHanlder {
	
	/**
	 * 需要写入数据库文件的队列
	 */
	public static final LinkedBlockingQueue<DataFile> DATA_FILE_QUEUE = new LinkedBlockingQueue<>();
	
	/**
	 * 需要写入数据库列表队列
	 */
	public static final LinkedBlockingQueue<List<DataRecord>> DATALIST_FILE_QUEUE = new LinkedBlockingQueue<>();
	
	private static final Logger logger = LoggerFactory.getLogger(DataHanlder.class); 
	
	@Autowired
	DataBiz dataBiz;
	
	/**
	 * 文件处理
	 */
	public void queueProcessor() {
		logger.info("DATA_FILE_QUEUE hanlder begin ....");
		for(;;) {
			try {
				DataFile dataFile = DATA_FILE_QUEUE.take();
				logger.info("file hanlde begin ...." + System.currentTimeMillis() / 1000L);
				// 数据处理
				dataBiz.dataPersistence(dataFile);
				logger.info("file hanlde end ...." + System.currentTimeMillis() / 1000L);
			} catch (InterruptedException e) {
				logger.error("数据处理队列异常",e);
				throw new BusinessException("数据处理队列异常");
			}
		}
	}
	
	/**
	 * 数据列表处理
	 */
	public void dataListQueueProcessor() {
		logger.info(Thread.currentThread().getName() + " DATALIST_FILE_QUEUE hanlder begin ....");
		for(;;) {
			try {
				
				List<DataRecord> dataRecords = DATALIST_FILE_QUEUE.take();
				logger.info("list queue hanlde begin ...." + System.currentTimeMillis() / 1000L);
				// 数据处理
				if(dataBiz.dataPersistence(dataRecords) < 1) {
		        	throw new BusinessException("列表数据写入数据库失败");
		        }
				logger.info("list queue hanlde end ...." + System.currentTimeMillis() / 1000L);
			} catch (InterruptedException e) {
				logger.error("数据处理队列异常",e);
			}
		}
	}
}
