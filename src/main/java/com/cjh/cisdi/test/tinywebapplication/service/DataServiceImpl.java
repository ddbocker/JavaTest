package com.cjh.cisdi.test.tinywebapplication.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.BusinessException;
import com.cjh.cisdi.test.tinywebapplication.common.ConfigBean;
import com.cjh.cisdi.test.tinywebapplication.common.ExcelUtils;
import com.cjh.cisdi.test.tinywebapplication.common.FileUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
import com.cjh.cisdi.test.tinywebapplication.mapper.DataFileMapper;

/**
 * 数据服务类
 * @author cjh
 *
 */
@Service
public class DataServiceImpl implements DataService{
	
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class); 

	@Autowired
	DataFileMapper dataFileMapper;
	
	@Autowired
	DataBiz dataBiz;
	
	@Autowired
	ConfigBean configBean;

	/**
	 * 上传文件
	 */
	@Override
	public boolean fileUpload(MultipartFile file) {
		// 读取文件并存储到对应目录
	    try {
	        byte[] bytes = file.getBytes();
	        // 获取文件类型
	        String fileType = FileUtils.getFileType(file.getOriginalFilename());
	        // 设置保存文件名
	        String newfilename = System.currentTimeMillis() + "";
	        String pathString = configBean.getUploadAddress() + System.currentTimeMillis() + fileType;
	        // 保存文件
	        Path path = Paths.get(pathString);
	        Files.write(path, bytes);
	        
	        // 添加上传记录
	        DataFile dataFile = new DataFile();
	        dataFile.setFilename(file.getOriginalFilename());
	        dataFile.setNewfilename(newfilename +fileType);
	        dataFile.setFiletype(fileType);
	        dataFile.setFilesize(file.getSize());
	        if(dataFileMapper.insertSelective(dataFile) < 1) {
	        	logger.error(file.getOriginalFilename() + "filerecord insert fail");
	        	throw new BusinessException("文件上传记录写入数据库失败");
	        };
	        
	        // 从文件中获取数据list
	        List<DataRecord> dataRecords = ExcelUtils.getDataListFromExcel(pathString);
	        
	        //写入数据库
	        if(dataBiz.dataPersistence(dataRecords) < 1) {
	        	logger.error(file.getOriginalFilename() + "datarecord insert fail");
	        	throw new BusinessException("文件数据写入数据库失败");
	        }
	    } catch (IOException e) {
	    	logger.error(file.getOriginalFilename() + "upload fail",e);
        	throw new BusinessException("上传文件读取失败");
	    }
		
		return true;
	}
	
	/**
	 * 分页获取数据
	 * @param page
	 * @return
	 */
	@Override
	public Page<DataRecord> getDataRecordPageResult(Integer page) {
 		return dataBiz.getDataRecordPageResult(page);
	}

}
