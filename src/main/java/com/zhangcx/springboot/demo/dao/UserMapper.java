package com.zhangcx.springboot.demo.dao;

import com.zhangcx.springboot.demo.entity.UserEntity;
import com.zhangcx.springboot.demo.entity.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-09-12
 **/
//@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(user_name,pass_word,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
