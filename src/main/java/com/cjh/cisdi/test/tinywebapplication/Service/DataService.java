package com.cjh.cisdi.test.tinywebapplication.service;

import org.springframework.web.multipart.MultipartFile;

import com.cjh.cisdi.test.tinywebapplication.common.PageResult;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;

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
	PageResult<DataRecord> getDataRecordPageResult(Integer page);
}
