package com.yefeng.boot_4.controller;

import com.yefeng.boot_4.common.JsonResult;
import com.yefeng.boot_4.common.ResultCode;
import com.yefeng.boot_4.common.ResultUtil;
import com.yefeng.boot_4.pojo.Help;
import com.yefeng.boot_4.service.HelpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/help")
public class HelpController {
    @Resource
    private HelpService helpService;

    @PostMapping("/addLike")
    public JsonResult<List<Help>> addLike(@RequestBody Help help){
        List<Help> helpList = helpService.addLike(help);
        return ResultUtil.success(helpList,ResultCode.SUCCESS);
    }

    @GetMapping("/getLikes")
    public JsonResult<List<Help>> getLikes(){
        List<Help> serviceLikes = helpService.getLikes();
        return ResultUtil.success(serviceLikes,ResultCode.SUCCESS);
    }

    @PostMapping("/updatedlike")
    public JsonResult<HashMap<String,Object>> UpdatedLike(@RequestBody Help help){
        List<Help> helpUser = helpService.updatedHelp(help);
        List<Help> helpList = helpService.getLikes();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userLikes",helpUser);
        hashMap.put("likes",helpList);
        return ResultUtil.success(hashMap,ResultCode.SUCCESS);
    }

    @GetMapping("/getUserLike/{uid}")
    public JsonResult<List<Help>> getUserLike(@PathVariable("uid") int uid){
        List<Help> userLikes = helpService.getUserLikes(uid);
        return ResultUtil.success(userLikes,ResultCode.SUCCESS);
    }

    @GetMapping("/getAllHelp/{uid}")
    public JsonResult<Integer> getAllHelp(@PathVariable("uid") int uid){
        Integer helpServiceAllHelps = helpService.getAllHelps(uid);
        return ResultUtil.success(helpServiceAllHelps,ResultCode.SUCCESS);
    }
}
