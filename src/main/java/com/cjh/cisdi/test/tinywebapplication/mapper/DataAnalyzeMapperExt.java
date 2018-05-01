package com.cjh.cisdi.test.tinywebapplication.mapper;

import java.util.List;

import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyze;

/**
 * 
 * @author cjh
 *
 */
public interface DataAnalyzeMapperExt {
	/**
	 * 批量写入数据
	 * @param dataAnalyzes
	 * @return
	 */
	int insert(List<DataAnalyze> dataAnalyzes);
}