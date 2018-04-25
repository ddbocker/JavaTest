package com.cjh.cisdi.test.tinywebapplication.Service;

import org.springframework.web.multipart.MultipartFile;

public interface DataService {
	/**
	 * 上传文件
	 * @return
	 */
	boolean fileUpload(MultipartFile file);
	
	/**
	 * 添加分析数据记录
	 * @return
	 */
	int addDataRecords();
}
