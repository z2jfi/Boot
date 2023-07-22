package com.yefeng.boot_1.DAO;

import com.yefeng.boot_1.pojo.User;

public interface UserMapper{
     User selectById(int id);

     User selectByNameAndPwd(User user);
}




