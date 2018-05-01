package com.cjh.cisdi.test.tinywebapplication.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;

/**
 * 
 * @author cjh
 *
 */
public interface DataRecordMapperExt {
	/**
	 * 批量写入数据
	 * @param dataRecords
	 * @return
	 */
	int insert(List<DataRecord> dataRecords);
	
	/**
	 * 获取数据详情列表
	 * @param fileId
	 * @return
	 */
	List<DataRecord> getDataRecordsByPage(@Param("fileId") Integer fileId);
}
