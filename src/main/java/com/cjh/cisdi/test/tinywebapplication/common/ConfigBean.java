package com.cjh.cisdi.test.tinywebapplication.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置帮助类
 * @author cjh
 *
 */
@Component
public class ConfigBean {
	
	@Value("${upload.file.address}")
	private String uploadAddress;
	
	public String getUploadAddress() {
		return uploadAddress;
	}

	public void setUploadAddress(String uploadAddress) {
		this.uploadAddress = uploadAddress;
	}
}
