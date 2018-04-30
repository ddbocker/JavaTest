package com.cjh.cisdi.test.tinywebapplication.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjh.cisdi.test.tinywebapplication.biz.DataBiz;
import com.cjh.cisdi.test.tinywebapplication.common.BusinessException;
import com.cjh.cisdi.test.tinywebapplication.common.ConfigBean;
import com.cjh.cisdi.test.tinywebapplication.common.CsvUtils;
import com.cjh.cisdi.test.tinywebapplication.common.DataHanlder;
import com.cjh.cisdi.test.tinywebapplication.common.FileUtils;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.enums.FileStatusTypeEnum;
import com.cjh.cisdi.test.tinywebapplication.enums.FileTypeEnum;
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
	    	logger.info("-------------copy begin----------" + System.currentTimeMillis() / 1000L);
	        byte[] bytes = file.getBytes();
	        File filedir =new File(configBean.getUploadAddress());    
	        //如果文件夹不存在则创建    
	        if (!filedir .exists() && !filedir.isDirectory()) {       
	        	filedir.mkdir();    
	        }   
	        // 获取文件类型
	        String fileType = FileUtils.getFileType(file.getOriginalFilename());
	        //判断文件名，暂时只支持csv
	        if(FileTypeEnum.getEnumByCode(fileType.toLowerCase()) == null) {
	        	throw new BusinessException("暂时仅支持.csv格式");
	        }
	        // 设置保存文件名
	        String newfilename = System.currentTimeMillis() + "";
	        String pathString = configBean.getUploadAddress() + newfilename + fileType;
	        // 保存文件
	        Path path = Paths.get(pathString);
	        Files.write(path, bytes);
	        logger.info("-------------copy end----------" + System.currentTimeMillis() / 1000L);
	        
	       
	        // 添加上传记录
	        DataFile dataFile = new DataFile();
	        dataFile.setFilename(file.getOriginalFilename());
	        dataFile.setNewfilename(newfilename +fileType);
	        dataFile.setFiletype(fileType);
	        dataFile.setFilesize(file.getSize());
	        dataFile.setFilepath(configBean.getUploadAddress());
	        if(dataFileMapper.insertSelective(dataFile) < 1) {
	        	logger.error(file.getOriginalFilename() + "filerecord insert fail");
	        	throw new BusinessException("文件上传记录写入数据库失败");
	        };
	        // 添加到队列
	        DataHanlder.DATA_FILE_QUEUE.offer(dataFile);
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
	
	/**
	 * 文件下载
	 */
	@Override
	public void fileDownLoad(Integer fileId, HttpServletResponse response) {
		if(fileId == null || fileId < 0) {
			throw new BusinessException("无效文件记录id");
		}
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(fileId);
		
		if(dataFile == null) {
			throw new BusinessException("未找到对应文件记录");
		}
		
		String filePath = dataFile.getFilepath() + dataFile.getNewfilename();
		File file = new File(filePath);
		if(!file.exists()) {
			throw new BusinessException("服务器未找到对应文件");
		}
		// 缓冲区
		byte[] buffer = new byte[1024];
		// 输入流
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		OutputStream os = null;
		try {
			// 开始下载
			response.setContentType("application/force-download");// 设置强制下载不打开
			// 中文乱码
			String formFileName = URLEncoder.encode(dataFile.getFilename(), "UTF-8"); 
			// 设置文件名
			response.addHeader("Content-Disposition", "attachment;fileName=" + formFileName);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			// 输出流
			os = response.getOutputStream();
			int i = bis.read(buffer);
			while (i != -1) {
				os.write(buffer);
				i = bis.read(buffer);
			}
		} catch (Exception e) {
			logger.error("download file exception",e);
			throw new BusinessException("下载文件失败");
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					logger.error("close BufferedInputStream exception",e);
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("close FileInputStream exception",e);
				}
			}

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("close OutputStream exception",e);
				}
			}
		}
	}
	
	/**
	 * 文件断点下载
	 */
	@Override
	public void fileDownLoadBreak(Integer fileId, HttpServletResponse response) {
		if(fileId == null || fileId < 0) {
			throw new BusinessException("无效文件记录id");
		}
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(fileId);
		
		if(dataFile == null) {
			throw new BusinessException("未找到对应文件记录");
		}
		
		String filePath = dataFile.getFilepath() + dataFile.getNewfilename();
		File file = new File(filePath);
		
		if(!file.exists()) {
			throw new BusinessException("服务器未找到对应文件");
		}
		
		// 缓冲区
		byte[] buffer = new byte[1024];
		// 输入流
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		OutputStream os = null;
		try {
			// 开始下载
			response.setContentType("application/force-download");// 设置强制下载不打开
			// 中文乱码
			String formFileName = URLEncoder.encode(dataFile.getFilename(), "UTF-8"); 
			// 设置文件名
			response.addHeader("Content-Disposition", "attachment;fileName=" + formFileName);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			// 输出流
			os = response.getOutputStream();
			int i = bis.read(buffer);
			// 计数器，模拟中断
			int count = 1;
			while (i != -1) {
				os.write(buffer);
				i = bis.read(buffer);
				count++;
				// 抛出异常
				if (count == 2) {
					throw new BusinessException("");
				}
			}
		}  catch (BusinessException e) {
			try {
				// 模拟中断
				Thread.sleep(5000);
			} catch (InterruptedException interruptedException) {
			}

			try {
				// 缓冲区
				byte[] buffer2 = new byte[1024];

				while (bis.read(buffer2) != -1) {
					os.write(buffer2);
				}
			} catch (IOException ioException) {
			}
		} catch (Exception e) {
			logger.error("download file exception",e);
			throw new BusinessException("下载文件失败");
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					logger.error("close BufferedInputStream exception",e);
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("close FileInputStream exception",e);
				}
			}

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("close OutputStream exception",e);
				}
			}
		}
	}
	
	/**
	 * 获取所有文件列表
	 */
	@Override
	public List<DataFile> getDataFiles() {
		return dataFileMapper.selectByExample(null);
	}
	
	/**
	 * 删除服务器文件
	 */
	@Override
	public boolean deleteFile(Integer fileId) {
		if(fileId == null) {
			throw new BusinessException("文件记录id不能为空");
		}
		DataFile dataFile = dataFileMapper.selectByPrimaryKey(fileId);
		if(dataFile == null) {
			throw new BusinessException("无对应记录");
		}
		
		if(!CsvUtils.deleteFile(dataFile.getFilepath() + dataFile.getNewfilename())) {
			throw new BusinessException("删除服务器文件失败");
		} 
		// 更新文件记录状态
		DataFile updateFile = new DataFile();
		updateFile.setId(dataFile.getId());
		updateFile.setStatus(FileStatusTypeEnum.TYPE_FAILED_AND_DELETE.getCode());
		if(dataFileMapper.updateByPrimaryKeySelective(updateFile) < 1) {
			logger.error("更新文件记录id" + updateFile.getId() + "状态失败");
			throw new BusinessException("更新文件记录状态失败");
		}			
		return true;
	}
}
