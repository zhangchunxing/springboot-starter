package com.zhangcx.springboot.demo.entity;

import lombok.*;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-09-12
 **/
@Setter
@Getter
public class UserEntity {
    private Long id;

    private String userName;

    private String nickName;

    private int userSex;

    private String passWord;

    private String address;

    public UserEntity() {
    }

    public UserEntity(String userName, String address, int userSex) {
        this.userName = userName;
        this.userSex = userSex;
        this.address = address;
    }

    public UserEntity(Long id, String userName, String nickName, int userSex, String passWord, String address) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.userSex = userSex;
        this.passWord = passWord;
        this.address = address;
    }
}
