package com.cjh.cisdi.test.tinywebapplication.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjh.cisdi.test.tinywebapplication.common.PageResult;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;

/**
 * 数据业务处理类
 * @author cjh
 *
 */
@Component
public class DataBiz {
	@Autowired
	DataRecordMapperExt dataRecordMapperExt;
	
	/**
	 * 默认页码
	 */
	private static final Integer DEFAULT_PAGE_CURRENT = 1;
	
	/**
	 * 每页获取条数
	 */
    private static final Integer DEFAULT_PAGE_SIZE = 30;
	
    /**
     * 批量写入数据库
     * @param dataList
     * @return
     */
	public int dataPersistence(List<DataRecord> dataList) {
		return dataRecordMapperExt.insert(dataList);
	}
	
	/**
	 * 分页获取数据
	 * @param page
	 * @return
	 */
	public PageResult<DataRecord> getDataRecordPageResult(Integer page) {
		return null;
	}
}
