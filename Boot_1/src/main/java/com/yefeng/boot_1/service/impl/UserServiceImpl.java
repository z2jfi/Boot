package com.yefeng.boot_1.service.impl;

import com.yefeng.boot_1.DAO.UserMapper;
import com.yefeng.boot_1.pojo.User;
import com.yefeng.boot_1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    public User UserLogin(User user){
        User selectByNameAndPwd = userMapper.selectByNameAndPwd(user);
        if (selectByNameAndPwd == null){
            throw new RuntimeException("账号或密码错误");
        }
        return selectByNameAndPwd;
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.selectById(id);
        if (user == null){
            throw new RuntimeException("无此id");
        }
        return user;
    }
}




