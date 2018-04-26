package com.cjh.cisdi.test.tinywebapplication.mapper;

import java.util.List;

import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;

public interface DataRecordMapperExt {
	/**
	 * 批量写入数据
	 * @param dataRecords
	 * @return
	 */
	int insert(List<DataRecord> dataRecords);
	
	
}
