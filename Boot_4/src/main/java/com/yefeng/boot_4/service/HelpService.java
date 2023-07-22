package com.yefeng.boot_4.service;

import com.yefeng.boot_4.pojo.Help;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yefeng
* @description 针对表【t_help】的数据库操作Service
* @createDate 2023-06-01 11:35:11
*/
public interface HelpService extends IService<Help> {
    List<Help> addLike(Help help);

    List<Help> getLikes();

    List<Help> updatedHelp(Help help);

    List<Help> getUserLikes(int uid);

    Integer getAllHelps(int uid);
}
