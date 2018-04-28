package com.cjh.cisdi.test.tinywebapplication.mapper;

import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;

public interface DataFileMapperExt {
	/**
	 * 乐观锁
	 * @param id
	 * @return
	 */
	DataFile selectForLock(Integer id);
	
	
}
