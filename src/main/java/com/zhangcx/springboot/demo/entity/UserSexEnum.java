package com.zhangcx.springboot.demo.entity;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-09-12
 **/
public enum UserSexEnum {
    MAN(0, "男"),
    WOMAN(1, "女");

    UserSexEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
