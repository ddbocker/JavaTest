package com.cjh.cisdi.test.tinywebapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cjh.cisdi.test.tinywebapplication.common.BusinessException;

/**
 * 异常处理器
 * @author cjh
 *
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {
	@ExceptionHandler(BusinessException.class)
    @ResponseStatus
    public Map<String, Object> handlerBusinessException(BusinessException ex) {
        Map<String,Object> result = new HashMap<>(2);
        result.put("message", ex.getMessage());
        result.put("error type", "BusinessException");
        return result;
    }
}
