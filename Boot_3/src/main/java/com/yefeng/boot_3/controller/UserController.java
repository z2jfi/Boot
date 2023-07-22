package com.yefeng.boot_3.controller;

import com.yefeng.boot_3.common.JsonResult;
import com.yefeng.boot_3.common.ResultCode;
import com.yefeng.boot_3.common.ResultUtil;
import com.yefeng.boot_3.pojo.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public JsonResult<User> Login(){
        return ResultUtil.success(new User(), ResultCode.SUCCESS);
    }
}
