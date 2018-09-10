package com.zhangcx.springboot.demo.controller;

import com.zhangcx.springboot.common.entity.vo.CommonResponse;
import com.zhangcx.springboot.common.exception.BizException;
import com.zhangcx.springboot.demo.entity.DemoReq;
import com.zhangcx.springboot.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description: springboot入门
 * @author: zhangchunxing
 * @create: 2018-08-07
 */
@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Value("${blog.address}")
    String address;

    @Value("${blog.author}")
    String author;

    @Value("${blog.desc}")
    String desc;

    @Value("${customer.var}")
    String name1;

    @Autowired
    Person person;

    @RequestMapping("/person")
    public String person() {
        return person.toString();
    }

    @RequestMapping("/name1")
    public String name1() {
        return name1;
    }

    @RequestMapping("/desc")
    public String desc() {
        return desc;
    }

    @RequestMapping("/address")
    public String address() {
        return address;
    }


    @RequestMapping("/")
    public String index() {
        LOGGER.info("hello Spring Boot!");
        return "hello Spring Boot!";
    }

    @RequestMapping("/handleException")
    public CommonResponse handleException() {
        BizException bizException = BizException.DB_GET_SEQ_NEXT_VALUE_ERROR;
        CommonResponse commonResponse = new CommonResponse();
        if (bizException != null) throw bizException;

        return commonResponse;

    }

    @GetMapping("/demo/valid")
    public String demoValid(@Valid DemoReq req) {
        return req.getCode() + "," + req.getName();
    }

}