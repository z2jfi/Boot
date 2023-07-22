package com.yefeng.boot_4.DAO;
import java.util.List;

import com.yefeng.boot_4.pojo.User;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yefeng
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-04-28 13:24:51
* @Entity com.yefeng.boot_4.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int insertAll(User user);

    List<User> selectByUsername(@Param("username") String username);

    User selectById(@Param("id") Integer id);
}




