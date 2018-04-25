package com.cjh.cisdi.test.tinywebapplication.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjh.cisdi.test.tinywebapplication.Dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.Mapper.DataFileMapper;
import com.cjh.cisdi.test.tinywebapplication.Mapper.DataRecordMapper;
import com.cjh.cisdi.test.tinywebapplication.common.ConfigBean;
import com.cjh.cisdi.test.tinywebapplication.common.FileUtils;

@Service
public class DataServiceImpl implements DataService{
	@Autowired
	DataRecordMapper dataRecordMapper;
	
	@Autowired
	DataFileMapper dataFileMapper;
	
	@Autowired
	ConfigBean configBean;

	@Override
	public int addDataRecords() {
		return 0;
	}

	@Override
	public boolean fileUpload(MultipartFile file) {
		
		//读取文件并存储到对应目录
	    try {
	        byte[] bytes = file.getBytes();
	        //获取文件类型
	        String fileType = FileUtils.getFileType(file.getOriginalFilename());
	        //设置保存文件名
	        String newfilename = System.currentTimeMillis() + "";
	        Path path = Paths.get(configBean.getUploadAddress() + System.currentTimeMillis() + fileType);
	        Files.write(path, bytes);
	        
	        //添加上传记录
	        DataFile dataFile = new DataFile();
	        dataFile.setFilename(file.getOriginalFilename());
	        dataFile.setNewfilename(newfilename +fileType);
	        dataFile.setFiletype(fileType);
	        dataFile.setFilesize(file.getSize());
	        if(dataFileMapper.insertSelective(dataFile) < 1) {
	        	//记录日志
	        };
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return true;
	}

}
