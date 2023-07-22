package com.yefeng.boot_4.controller;

import com.yefeng.boot_4.common.JsonResult;
import com.yefeng.boot_4.common.ResultCode;
import com.yefeng.boot_4.common.ResultUtil;
import com.yefeng.boot_4.pojo.Log;
import com.yefeng.boot_4.pojo.User;
import com.yefeng.boot_4.pojo.Users;
import com.yefeng.boot_4.service.LogService;
import com.yefeng.boot_4.service.UserService;
import com.yefeng.boot_4.utils.JwtUtils;
import com.yefeng.boot_4.utils.RedisUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public JsonResult<HashMap<String,Object>> Login(@RequestBody User user){
        User userLogin = userService.UserLogin(user);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (userLogin != null){
            Log log = new Log();
            log.setUid(userLogin.getId());
            log.setContent("登录系统");
            log.setDate(new Date());
            logService.addLog(log);
            String token = JwtUtils.getToken(userLogin);
            hashMap.put("token",token);
            hashMap.put("user",userLogin);
            return ResultUtil.success(hashMap,ResultCode.SUCCESS);
        }
        return ResultUtil.faile(ResultCode.USER_LOGIN_ERROR);
    }

    @PostMapping("/register")
    public JsonResult<String> Register(@RequestBody User user){

        String userCode = user.getCode();
        System.out.println(userCode);
        if (!redisUtil.exists("check")){
            return ResultUtil.faile(ResultCode.CODE_AUTH_ERROR);
        }
        if (redisUtil.get("check").toString().equals(userCode)){
            try {
                int userRegister = userService.UserRegister(user);
                if (userRegister > 0){
                    return ResultUtil.successNoData(ResultCode.SUCCESS);
                }
            } catch (Exception e) {
                return ResultUtil.faile(ResultCode.USER_HAS_EXISTED);
            }
        }
        return ResultUtil.faile(ResultCode.FAILURE);
    }

    @GetMapping("/register/code")
    public JsonResult<HashMap<String,Object>> getCode(){
        HashMap<String, Object> hashMap = new HashMap<>();
        int code1 = (int)(Math.random() * Math.pow(10,6));
        String value = String.valueOf(code1);
        redisUtil.set("check",value,60);
        hashMap.put("check",value);
        return ResultUtil.success(hashMap,ResultCode.SUCCESS);
    }

    @PostMapping("/upload")
    public JsonResult<HashMap<String,Object>> Upload(MultipartFile file, HttpServletRequest request){
        if (Objects.isNull(file) || file.isEmpty()){
            return ResultUtil.faile(ResultCode.FAILURE);
        }
        try {
            String token = request.getHeader("token");
            String uploadImage = userService.uploadImage(file,token);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("url",uploadImage);
            return ResultUtil.success(hashMap,ResultCode.SUCCESS);
        } catch (Exception e) {
            return ResultUtil.faile(ResultCode.FAILURE);
        }
    }

    @PostMapping("/modifyname")
    public JsonResult<String> ModifyName(@RequestBody Users users){
        if (userService.uploadUname(users)){
            return ResultUtil.successNoData(ResultCode.SUCCESS);
        }
        return ResultUtil.faile(ResultCode.FAILURE);
    }

    @PostMapping("/modifyusers")
    public JsonResult<HashMap<String,Object>> ModifyUsers(@RequestBody Users users){
        User user = userService.uploadUsers(users);

        if (user!= null){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("user",user);
            return ResultUtil.success(hashMap,ResultCode.SUCCESS);
        }
        return ResultUtil.faile(ResultCode.FAILURE);
    }

}
