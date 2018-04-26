package com.cjh.cisdi.test.tinywebapplication.common;

/**
 * 自定义异常类
 * @author cjh
 *
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -8390967212073039616L;
	
	public BusinessException(String message) {
        super(message);
    }
}
