package com.yefeng.boot_4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_4.DAO.UsersMapper;
import com.yefeng.boot_4.pojo.User;
import com.yefeng.boot_4.pojo.Users;
import com.yefeng.boot_4.service.UserService;
import com.yefeng.boot_4.DAO.UserMapper;
import com.yefeng.boot_4.utils.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
* @author yefeng
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-04-28 13:24:51
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    private final static  String IMAGE_PATH = "D:\\Code\\Web\\model_5\\src\\static\\";

    @Resource
    private UserMapper userMapper;

    @Resource
    private UsersMapper usersMapper;

    @Override
    public User UserLogin(User user) {
        User usernameAndPassword = userMapper.selectByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (usernameAndPassword != null){
            usernameAndPassword.setPassword("");
            Users users = usersMapper.selectByUid(usernameAndPassword.getId());
            usernameAndPassword.setUsers(users);
        }
        return usernameAndPassword;
    }

    @Override
    public int UserRegister(User user) {
        user.setRoot(0);
        user.setState(0);
        List<User> userList = userMapper.selectByUsername(user.getUsername());
        System.out.println(userList.size());
        if (userList.size() != 0){
            throw new RuntimeException("账号已存在");
        }
        int i = userMapper.insertAll(user);
        User byUsernameAndPassword = userMapper.selectByUsernameAndPassword(user.getUsername(), user.getPassword());
        Users users = new Users();
        users.setUid(byUsernameAndPassword.getId());
        usersMapper.insertSelective(users);
        return i;
    }

    @Override
    public String uploadImage(MultipartFile file, String token) {
        try {
            String filename = file.getOriginalFilename();
            String fileSuffix = filename.substring(filename.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String savePath = IMAGE_PATH + uuid + fileSuffix;
            File f = new File(savePath);
            if (!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            file.transferTo(f);
            User userNameByToken = JwtUtils.getUserNameByToken(token);
            Users users = new Users();
            users.setUid(userNameByToken.getId());
            users.setImage(savePath);
            usersMapper.updateSelective(users);
            return savePath;
        } catch (Exception e) {
            throw new RuntimeException("操作失败");
        }
    }

    @Override
    public boolean uploadUname(Users users) {
        int byUid = usersMapper.updateUnameByUid(users.getUname(), users.getUid());
        if (byUid > 0){
            return true;
        }
        return false;
    }

    @Override
    public User uploadUsers(Users users) {
        User user = null;
        int i = usersMapper.updateSelective(users);
        if (i > 0){
            Users byUid = usersMapper.selectByUid(users.getUid());
            User selectById = userMapper.selectById(users.getUid());
            selectById.setUsers(byUid);
            user = selectById;
        }
        return user;
    }
}




