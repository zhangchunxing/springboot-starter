package com.zhangcx.springboot.common.exception;

import com.zhangcx.springboot.common.entity.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 异常处理器
 * @author: zhangchunxing
 * @create: 2018-09-08
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {
	

	/**
	 * 拦截BizException类的异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	@ResponseBody
	public CommonResponse handleBizException(HttpServletRequest request, BizException ex){
		CommonResponse response = new CommonResponse();
		response.setMsg(ex.getMsg());
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
	public CommonResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		FieldError fieldError = ex.getBindingResult().getFieldError();
		log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        CommonResponse response = new CommonResponse();
        response.setMsg(fieldError.getDefaultMessage());
		return response;
	}


	@ExceptionHandler(BindException.class)
    @ResponseBody
	public CommonResponse handleBindException(BindException ex) {
		//校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
		FieldError fieldError = ex.getBindingResult().getFieldError();
		log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        CommonResponse response = new CommonResponse();
        response.setMsg(fieldError.getDefaultMessage());
		return response;
	}
}
