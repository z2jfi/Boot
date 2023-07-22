package com.yefeng.boot_1;

import com.yefeng.boot_1.DAO.UserMapper;
import com.yefeng.boot_1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Boot1ApplicationTests {

    @Resource
    private UserMapper userMapper;


    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
