package com.cjh.cisdi.test.tinywebapplication.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
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
	
	@Autowired
	DataRecordMapper dataRecordMapper;
	/**
	 * 默认页码
	 */
	private static final Integer DEFAULT_PAGE_CURRENT = 1;
	
	/**
	 * 每页获取条数
	 */
    private static final Integer DEFAULT_PAGE_SIZE = 5;
	
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
	 * @param page 当前页码
	 * @return
	 */
	public Page<DataRecord> getDataRecordPageResult(Integer page) {
		if(page == null || page == 0) {
			page = DEFAULT_PAGE_CURRENT;
		}
		PageInterceptor.startPage(page, DEFAULT_PAGE_SIZE);
		dataRecordMapper.selectByExample(null);
		return PageInterceptor.endPage();
	}
}
