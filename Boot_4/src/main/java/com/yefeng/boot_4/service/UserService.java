package com.yefeng.boot_4.service;

import com.yefeng.boot_4.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yefeng.boot_4.pojo.Users;
import org.springframework.web.multipart.MultipartFile;

/**
* @author yefeng
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-04-28 13:24:51
*/
public interface UserService extends IService<User> {
   User UserLogin(User user);

   int UserRegister(User user);

   String uploadImage(MultipartFile file, String token);

   boolean uploadUname(Users users);

   User uploadUsers(Users users);
}
