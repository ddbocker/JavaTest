package com.cjh.cisdi.test.tinywebapplication.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件类型枚举
 * @author cjh
 *
 */
public enum FileTypeEnum {
	/** 0,.xls**/
	TYPE_XLS(0, ".xls"),

	/** 1,.xlsx **/
	TYPE_XLSX(1, ".xlsx");

	/**
	 * @Description: 构造方法
	 * @param code
	 *            响应码
	 * @param message
	 *            响应信息
	 */
	private FileTypeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 响应码
	 */
	private Integer code = null;
	/**
	 * 响应信息
	 */
	private String message = null;

	/**
	 * @return code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            要设置的 code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            要设置的 message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @Method: getEnumByCode
	 * @param @param code
	 * @param @return
	 * @return Enummessage
	 * @throws
	 */
	public static FileTypeEnum getEnumByCode(String code) {
		if (null == code) {
			return null;
		}
		for (FileTypeEnum type : values()) {
			if (type.getCode().equals(code.trim()))
				return type;
		}
		return null;
	}

	/**
	 * 
	 * @Method: toMap
	 * @Description: 转换为Map对象
	 * @param @return
	 * @return Map<String,String>
	 * @throws
	 */
	public static Map<Integer, String> toMap() {
		Map<Integer, String> enumDataMap = new HashMap<Integer, String>();
		for (FileTypeEnum type : values()) {
			enumDataMap.put(type.getCode(), type.getMessage());
		}
		return enumDataMap;
	}
}
