package com.cjh.cisdi.test.tinywebapplication.enums;


/**
 * 数据分析类型枚举
 * @author cjh
 *
 */
public enum AnalyzeTypeEnum {
	/** 数字**/
	TYPE_NUM(0),

	/** 字符 **/
	TYPE_CHAR(1);

	/**
	 * @Description: 构造方法
	 * @param code
	 *            响应码
	 */
	private AnalyzeTypeEnum(Integer code) {
		this.code = code;
	}

	/**
	 * 响应码
	 */
	private Integer code = null;

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
	 * 
	 * @Method: getEnumByCode
	 * @param @param code
	 * @param @return
	 * @return FileTypeEnum
	 * @throws
	 */
	public static AnalyzeTypeEnum getEnumByCode(Integer code) {
		if (null == code) {
			return null;
		}
		for (AnalyzeTypeEnum type : values()) {
			if (type.getCode().equals(code))
				return type;
		}
		return null;
	}

}
