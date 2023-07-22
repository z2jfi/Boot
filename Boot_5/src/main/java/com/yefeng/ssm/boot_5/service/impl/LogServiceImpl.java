package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Log;
import com.yefeng.ssm.boot_5.service.LogService;
import com.yefeng.ssm.boot_5.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【t_log】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

}




