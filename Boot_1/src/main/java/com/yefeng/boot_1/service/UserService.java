package com.yefeng.boot_1.service;

import com.yefeng.boot_1.pojo.User;

public interface UserService {

   public User UserLogin(User user);
   public User getUserById(int id);
}
