package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.User;
import com.yefeng.ssm.boot_5.service.UserService;
import com.yefeng.ssm.boot_5.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




