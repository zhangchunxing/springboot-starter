package com.zhangcx.springboot.common.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @description: api返回
 * @author: zhangchunxing
 * @create: 2018-09-08
 */
@Setter
@Getter
public class CommonResponse<T> {

	private String msg = "success";
	private int code = 0;
	private T data;


}