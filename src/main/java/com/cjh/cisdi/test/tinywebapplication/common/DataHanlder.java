package com.cjh.cisdi.test.tinywebapplication.common;

import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;

@Component
public class DataHanlder {
	
	/**
	 * 需要写入数据库文件的队列
	 */
	public static final LinkedBlockingQueue<DataFile> DATA_FILE_QUEUE = new LinkedBlockingQueue<>();
	
	private static final Logger logger = LoggerFactory.getLogger(DataHanlder.class); 
	
	@Autowired
	DataBiz dataBiz;
	
	public void queueProcessor() {
		logger.info("queueHanlder begin ....");
		for(;;) {
			try {
				final DataFile dataFile = DATA_FILE_QUEUE.take();
				dataBiz.dataPersistence(dataFile);
			} catch (InterruptedException e) {
				logger.error("数据处理队列异常",e);
				throw new BusinessException("数据处理队列异常");
			}
		}
	}
}
