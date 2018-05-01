package com.cjh.cisdi.test.tinywebapplication.enums;


/**
 * 文件类型枚举
 * @author cjh
 *
 */
public enum FileTypeEnum {
	/** .csv**/
	TYPE_CSV(".csv");

	/**
	 * @Description: 构造方法
	 * @param code
	 *            响应码
	 */
	private FileTypeEnum(String code) {
		this.code = code;
	}

	/**
	 * 响应码
	 */
	private String code = null;

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            要设置的 code
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * 
	 * @Method: getEnumByCode
	 * @param @param code
	 * @param @return
	 * @return FileTypeEnum
	 * @throws
	 */
	public static FileTypeEnum getEnumByCode(String code) {
		if (null == code) {
			return null;
		}
		for (FileTypeEnum type : values()) {
			if (type.getCode().equals(code.trim())) {
				return type;
			}
		}
		return null;
	}

}
