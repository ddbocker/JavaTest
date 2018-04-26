package com.cjh.cisdi.test.tinywebapplication.common;

/**
 * 文件帮助类
 * @author cjh
 */
public class FileUtils {
	
	/**
	 * 根据文件名获取文件类型
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName) {
		if(fileName != null) {
			String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
			return fileTyle;
		}else {
			return null;
		}
	}
}
