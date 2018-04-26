package com.cjh.cisdi.test.tinywebapplication.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cjh.cisdi.test.tinywebapplication.common.BusinessException;
import com.cjh.cisdi.test.tinywebapplication.common.ConfigBean;
import com.cjh.cisdi.test.tinywebapplication.common.ExcelUtils;
import com.cjh.cisdi.test.tinywebapplication.common.FileUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataRecordMapperExt;
import com.cjh.cisdi.test.tinywebapplication.service.DataServiceImpl;

/**
 * 数据业务处理类
 * @author cjh
 *
 */
@Component
public class DataBiz {
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class); 
	
	/**
	 * 默认页码
	 */
	private static final Integer DEFAULT_PAGE_CURRENT = 1;
	
	/**
	 * 每页获取条数
	 */
    private static final Integer DEFAULT_PAGE_SIZE = 5;
    
    /**
     * 每次插入数据行数
     */
    private static final Integer INSERT_SIZE = 10;
    
    @Autowired
	DataRecordMapperExt dataRecordMapperExt;
	
	@Autowired
	DataRecordMapper dataRecordMapper;
	
	@Autowired
	ConfigBean configBean;
	
    /**
     * 批量写入数据库
     * @param dataList
     * @return
     */
	public int dataPersistence(List<DataRecord> dataList) {
		return dataRecordMapperExt.insert(dataList);
	}
	
	/**
	 * 分批写入数据库
	 * @param dataFile 上传文件记录
	 * @return
	 */
	@Transactional(rollbackFor={Exception.class,RuntimeException.class})
	public int dataPersistence(DataFile dataFile) {
		String filePath = configBean.getUploadAddress() + dataFile.getNewfilename();
		// 取上传文件数据行数
		Integer fileRows = ExcelUtils.getFileRows(filePath);
		if(fileRows > 0) {
			int pages = fileRows / INSERT_SIZE;
			if(pages > 0) {
				for (int i = 0; i <= pages; i++) {
					if(i != pages) {
						List<DataRecord> dataRecords = ExcelUtils.getDataListFromExcel(filePath,i * INSERT_SIZE + 1, (i+1) * INSERT_SIZE);
						if(dataPersistence(dataRecords) < 1) {
				        	logger.error(dataFile.getFilename() + "datarecord insert fail");
				        	throw new BusinessException("文件数据写入数据库失败");
				        }
					}else {
						List<DataRecord> dataRecords = ExcelUtils.getDataListFromExcel(filePath,i * INSERT_SIZE + 1, fileRows);
						if(dataPersistence(dataRecords) < 1) {
				        	logger.error(dataFile.getFilename() + "datarecord insert fail");
				        	throw new BusinessException("文件数据写入数据库失败");
				        }
					}
					
				}
			}
		}
		return 1;
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
