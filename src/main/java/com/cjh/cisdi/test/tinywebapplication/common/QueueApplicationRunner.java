package com.cjh.cisdi.test.tinywebapplication.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class QueueApplicationRunner implements ApplicationRunner{
	@Autowired
	DataHanlder dataHanlder;
	
	private static final Logger logger = LoggerFactory.getLogger(QueueApplicationRunner.class); 
	
	private static int FAIL_NO = 0;
	
	private static final int MAX_FAIL_NO = 2;
	
	private static final Integer THREAD_SIZE = 1;
	
    @Override
    public void run(ApplicationArguments var1) throws Exception{
    	
    	ExecutorService executorService = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
    	
    	try {
    		executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					dataHanlder.queueProcessor();
				}
			});
		} catch (Exception e) {
			FAIL_NO++;
			// 重试3次
			if(FAIL_NO > MAX_FAIL_NO) {
				logger.error("QueueApplicationRunner has shutdown");
			}else {
				run(null);
			}
		}	
    }

}