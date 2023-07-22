package com.yefeng.boot_4.service;

import com.yefeng.boot_4.pojo.Log;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yefeng
* @description 针对表【t_log】的数据库操作Service
* @createDate 2023-05-31 19:19:43
*/
public interface LogService extends IService<Log> {
   void addLog(Log log);

   List<Log> getLogs();
}
