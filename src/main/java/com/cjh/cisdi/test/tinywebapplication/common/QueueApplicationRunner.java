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

/**
 * 消费线程
 * @author cjh
 *
 */
@Component
@Order(value = 1)
public class QueueApplicationRunner implements ApplicationRunner{
	@Autowired
	DataHanlder dataHanlder;
	
	private static final Logger logger = LoggerFactory.getLogger(QueueApplicationRunner.class); 
	
	private static final Integer THREAD_SIZE = 1;
	
    @Override
    public void run(ApplicationArguments var1) throws Exception{
    	
    	ExecutorService executorService = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
    	
    	// 文件处理器
    	executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// 当前失败次数
				int failNo = 0;
				// 最大重试次数
				int maxFailNo = 2;
				
				try {
					// 消费文件队列，写入数据库
					dataHanlder.queueProcessor();
				} catch (Exception e) {
					failNo++;
					// 重试3次
					if(failNo > maxFailNo) {
						logger.error("QueueApplicationRunner file queue hanlder has shutdown");
					}else {
						dataHanlder.queueProcessor();
					}
				}	
				
			}
		});
    	
    	// 文件内容分段消费处理器
    	/*for (int i = 0; i < THREAD_SIZE - 1; i++) {
    		executorService.execute(new Runnable() {
    			
    			@Override
    			public void run() {
    				// 当前失败次数
    				int fail_no = 0;
    				// 最大重试次数
    				int max_fail_no = 2;
    				
    				try {
    					// 消费列表队列，写入数据库
    					dataHanlder.dataListQueueProcessor();
    				} catch (Exception e) {
    					fail_no++;
    					// 重试3次
    					if(fail_no > max_fail_no) {
    						logger.error("QueueApplicationRunner list queue hanlder has shutdown");
    					}else {
    						dataHanlder.dataListQueueProcessor();
    					}
    				}	
    				
    			}
    		});
		}*/
    	
    }

}