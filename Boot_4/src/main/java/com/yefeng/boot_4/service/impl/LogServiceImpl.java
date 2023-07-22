package com.yefeng.boot_4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_4.pojo.Log;
import com.yefeng.boot_4.service.LogService;
import com.yefeng.boot_4.DAO.LogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author yefeng
* @description 针对表【t_log】的数据库操作Service实现
* @createDate 2023-05-31 19:19:43
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

    @Resource
    private LogMapper logMapper;

    @Override
    public void addLog(Log log) {
        int selective = logMapper.insertSelective(log);
    }

    @Override
    public List<Log> getLogs() {
        return logMapper.selectAll();
    }
}




