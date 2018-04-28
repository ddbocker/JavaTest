package com.cjh.cisdi.test.tinywebapplication.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.enums.FileTypeEnum;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/**
 * csv帮助类
 * 
 * @author cjh
 * 
 */
public class CsvUtils {
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
	
	/**
	 * 修改csv文件某单元格内容
	 * @param rowNum 行号
	 * @param columnNum 列号
	 * @param value 修改的值
	 * @param dataFile 文件记录
	 * @return
	 */
	public static boolean updateCsvFile(Integer rowNum,Integer columnNum,String value,DataFile dataFile) {
		
		if(dataFile == null) {
			return false;
		}
		
		if(dataFile.getFiletype() != null && !dataFile.getFiletype().toLowerCase().equals(FileTypeEnum.TYPE_CSV.getCode())) {
			return false;
		}
		// 读取文件
		CsvReader csvReader = null;
		
		String newfilePath = dataFile.getFilepath() + "temp_" + dataFile.getId() + dataFile.getFiletype();
		
		String oldFilePath = dataFile.getFilepath() + dataFile.getNewfilename();
		// 创建CSV写对象
        CsvWriter csvWriter = new CsvWriter(newfilePath,',', Charset.forName("UTF-8"));
		try {
			csvReader = new CsvReader(oldFilePath);
			//计数器
			int rowCount = 0;
			
			while (csvReader.readRecord()){
				rowCount ++ ;
				// 不改动的数据直接写入新文件
				String [] content = new String[csvReader.getColumnCount()];
				if(rowCount != rowNum) {
					for (int i = 0; i < content.length; i++) {
						content[i] = csvReader.get(i);
					}
					csvWriter.writeRecord(content);
					content = null;
					continue;
				}
				
				for (int i = 0; i < content.length; i++) {
					if(i == columnNum) {
						content[i] = value;
						continue;
					}
					content[i] = csvReader.get(i);
				}
				csvWriter.writeRecord(content);
				content = null;
			}
		} catch (IOException e) {
			logger.error("csv file read fail",e);
		}finally {
			if(csvReader != null) {
				csvReader.close();
			}
			
			if(csvWriter != null) {
				csvWriter.close();
			}
		}
		//删除源文件
		deleteFile(oldFilePath);
		//重命名temp文件
		renameFile(newfilePath,oldFilePath);
		return true;
	}
	
	/**
	 * 删除csv文件某行内容
	 * @param rowNum 行号
	 * @param dataFile 文件记录
	 * @return
	 */
	public static boolean deleteCsvFileForRow(Integer rowNum,DataFile dataFile) {
		
		if(dataFile == null) {
			return false;
		}
		
		if(dataFile.getFiletype() != null && !dataFile.getFiletype().equals(FileTypeEnum.TYPE_CSV.getCode())) {
			return false;
		}
		CsvReader csvReader = null;
		// 新文件路径
		String newfilePath = dataFile.getFilepath() + "temp_" + dataFile.getId() + dataFile.getFiletype();
		// 老文件路径
		String oldFilePath = dataFile.getFilepath() + dataFile.getNewfilename();
		// 创建CSV写对象
        CsvWriter csvWriter = new CsvWriter(newfilePath,',', Charset.forName("UTF-8"));
		try {
			csvReader = new CsvReader(oldFilePath);
			//计数器
			int rowCount = 0;
			
			while (csvReader.readRecord()){
				rowCount ++ ;
				// 不改动的数据直接写入新文件
				String [] content = new String[csvReader.getColumnCount()];
				if(rowCount != rowNum) {
					for (int i = 0; i < content.length; i++) {
						content[i] = csvReader.get(i);
					}
					csvWriter.writeRecord(content);
					content = null;
				}
			}
		} catch (IOException e) {
			logger.error("csv file read fail",e);
		}finally {
			if(csvReader != null) {
				csvReader.close();
			}
			
			if(csvWriter != null) {
				csvWriter.close();
			}
		}
		//删除源文件
		deleteFile(oldFilePath);
		//重命名temp文件
		renameFile(newfilePath,oldFilePath);
		return true;
	}
	
	/**
	 * 删除csv文件某列内容
	 * @param columnNum 列号
	 * @param dataFile 文件记录
	 * @return
	 */
	public static boolean deleteCsvFileForColumn(Integer columnNum,DataFile dataFile) {
		if(dataFile == null) {
			return false;
		}
		
		if(dataFile.getFiletype() != null && !dataFile.getFiletype().equals(FileTypeEnum.TYPE_CSV.getCode())) {
			return false;
		}
		CsvReader csvReader = null;
		// 新文件路径
		String newfilePath = dataFile.getFilepath() + "temp_" + dataFile.getId() + dataFile.getFiletype();
		// 老文件路径
		String oldFilePath = dataFile.getFilepath() + dataFile.getNewfilename();
		// 创建CSV写对象
		CsvWriter csvWriter = new CsvWriter(newfilePath,',', Charset.forName("UTF-8"));
		try {
			csvReader = new CsvReader(dataFile.getFilepath() + dataFile.getNewfilename());
			
			columnNum = columnNum - 1;
			while (csvReader.readRecord()) {
				// 不改动的数据直接写入新文件
				String [] content = new String[csvReader.getColumnCount()];
				for (int i = 0; i < content.length; i++) {
					if(i < columnNum) {
						content[i] = csvReader.get(i);
					}else if(i > columnNum) {
						content[i - 1] = csvReader.get(i);
					}
				}
				csvWriter.writeRecord(content);
				content = null;
			}
		} catch (IOException e) {
			logger.error("csv file read fail",e);
		}finally {
			if(csvReader != null) {
				csvReader.close();
			}
			
			if(csvWriter != null) {
				csvWriter.close();
			}
		}
		//删除源文件
		deleteFile(oldFilePath);
		//重命名temp文件
		renameFile(newfilePath,oldFilePath);
		return true;
	}
	
	/**
    * 删除单个文件
    *
    * @param filePath
    * @return 单个文件删除成功返回true，否则返回false
    */
   public static boolean deleteFile(String filePath) {
       File file = new File(filePath);
       // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
       if (file.exists() && file.isFile()) {
           if (file.delete()) {
               return true;
           } else {
               return false;
           }
       } else {
    	   logger.error("删除单个文件失败：" + filePath + "不存在！");
           return false;
       }
   }
   
   /**
    * 重命名文件
    *
    * @param filePath 原路径名
    * @param newFilePath 新文件名    
    * @return 成功返回true，否则返回false
    */
   public static boolean renameFile(String filePath,String newFilePath) {
       File file = new File(filePath);
       // 如果文件路径所对应的文件存在，并且是一个文件，则重命名
       if (file.exists() && file.isFile()) {
    	    // new file  
    	    File newFile = new File(newFilePath);  
           if (file.renameTo(newFile)) {
               return true;
           } else {
               return false;
           }
       } else {
    	   logger.error("重命名文件失败：" + filePath + "不存在！");
           return false;
       }
   }

}
