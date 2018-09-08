package com.zhangcx.springboot.common.exception;

import com.zhangcx.springboot.common.entity.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
}
