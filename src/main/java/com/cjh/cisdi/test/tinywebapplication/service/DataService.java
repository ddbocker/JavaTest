package com.cjh.cisdi.test.tinywebapplication.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyze;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;

/**
 * 文件数据处理
 * @author cjh
 *
 */
public interface DataService {
	/**
	 * 上传文件
	 * @return
	 */
	boolean fileUpload(MultipartFile file);
	
	/**
	 * 分页获取数据记录
	 * @param fileId
	 * @param page
	 * @return
	 */
	Page<DataRecord> getDataRecordPageResult(Integer fileId,Integer page);
	
	/**
	 * 获取所有文件记录
	 * @return
	 */
	List<DataFile> getDataFiles();
	
	/**
	 * 文件下载
	 * @param fileId data_file文件记录id
	 * @param response
	 * @return
	 */
	void fileDownLoad(Integer fileId,HttpServletResponse response);
	
	/**
	 * 文件断点下载
	 * @param fileId
	 * @param response
	 * @return
	 */
	void fileDownLoadBreak(Integer fileId,HttpServletResponse response);
	
	/**
	 * 删除服务器文件
	 * @param fileId
	 * @return
	 */
	boolean deleteFile(Integer fileId);
	
	/**
	 * 获取文件分析记录
	 * @param fileId
	 * @return
	 */
	List<DataAnalyze> getDataAnalyzes(Integer fileId);
}
