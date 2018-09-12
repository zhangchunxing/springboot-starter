package com.zhangcx.springboot;

import com.zhangcx.springboot.demo.dao.UserMapper;
import com.zhangcx.springboot.demo.entity.UserEntity;
import com.zhangcx.springboot.demo.entity.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-09-12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper UserMapper;

    @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new UserEntity("aa", "a123456", 0));
        UserMapper.insert(new UserEntity("bb", "b123456", 0));
        UserMapper.insert(new UserEntity("cc", "b123456", 0));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = UserMapper.getAll();
        System.err.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        UserEntity user = UserMapper.getOne(13L);
        System.out.println(user.toString());
        user.setNickName("neo");
        UserMapper.update(user);
        Assert.assertTrue(("neo".equals(UserMapper.getOne(13L).getNickName())));
    }
}