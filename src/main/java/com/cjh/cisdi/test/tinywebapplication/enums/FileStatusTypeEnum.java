package com.cjh.cisdi.test.tinywebapplication.enums;


/**
 * 上传文件记录状态
 * @author cjh
 *
 */
public enum FileStatusTypeEnum {
	/** 0,处理中**/
	TYPE_PROCESSING(0,"处理中"),

	/** 1，处理成功 **/
	TYPE_SUCCESS(1,"处理成功"),
	
	/** 2，处理失败 **/
	TYPE_FAILED(2,"处理失败"),
	
	/** 3：处理失败源文件已删除**/
	TYPE_FAILED_AND_DELETE(3,"处理失败源文件已删除");

	/**
	 * @Description: 构造方法
	 * @param code
	 * @param message
	 *            响应码
	 */
	private FileStatusTypeEnum(Integer code,String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 响应码
	 */
	private Integer code = null;
	
	private String message = null;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
	public static FileStatusTypeEnum getEnumByCode(Integer code) {
		if (null == code) {
			return null;
		}
		for (FileStatusTypeEnum type : values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}

}
