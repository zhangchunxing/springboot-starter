package com.zhangcx.springboot.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: ${DESCRIPTION}
 * @author: zhangchunxing
 * @create: 2018-09-07
 */
@Component
@ConfigurationProperties(prefix="person")
@Data
public class Person {
	private String name;

	private int age;

	private List<String> hobby;

}
