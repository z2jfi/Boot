package com.yefeng.boot_4.controller;

import com.yefeng.boot_4.common.JsonResult;
import com.yefeng.boot_4.common.ResultCode;
import com.yefeng.boot_4.common.ResultUtil;
import com.yefeng.boot_4.pojo.Log;
import com.yefeng.boot_4.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/log")
public class LogController {
    @Resource
    private LogService logService;

    @GetMapping("/outUser/{id}")
    public void OutUserLog(@PathVariable("id") int id){
        Log log = new Log();
        log.setUid(id);
        log.setContent("退出系统");
        log.setDate(new Date());
        logService.addLog(log);
    }

    @GetMapping("/getLogs")
    public JsonResult<List<Log>> getLogs(){
        List<Log> logList = logService.getLogs();

        return ResultUtil.success(logList, ResultCode.SUCCESS);
    }


}
