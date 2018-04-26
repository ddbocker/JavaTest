package com.cjh.cisdi.test.tinywebapplication.service;

import org.springframework.web.multipart.MultipartFile;

import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;

public interface DataService {
	/**
	 * 上传文件
	 * @return
	 */
	boolean fileUpload(MultipartFile file);
	
	/**
	 * 分页获取数据
	 * @param page
	 * @return
	 */
	Page<DataRecord> getDataRecordPageResult(Integer page);
}
