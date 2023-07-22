package com.yefeng.boot_4.DAO;
import com.yefeng.boot_4.pojo.Users;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yefeng
* @description 针对表【t_users】的数据库操作Mapper
* @createDate 2023-05-21 19:19:53
* @Entity com.yefeng.boot_4.pojo.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    int insertSelective(Users users);

    int updateSelective(Users users);

    int updateUnameByUid(@Param("uname") String uname, @Param("uid") Integer uid);

    Users selectByUid(@Param("uid") Integer uid);
}




