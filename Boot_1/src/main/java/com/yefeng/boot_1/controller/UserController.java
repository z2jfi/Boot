package com.yefeng.boot_1.controller;

import com.yefeng.boot_1.common.ResultData;
import com.yefeng.boot_1.pojo.User;
import com.yefeng.boot_1.service.UserService;
import com.yefeng.boot_1.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ResultData<HashMap<String,Object>> Login(@RequestBody User user){
        try {
            User userLogin = userService.UserLogin(user);
            String token = JwtUtils.getToken(userLogin);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("token",token);
            userLogin.setPassword("");
            hashMap.put("user",userLogin);
            return ResultData.success(hashMap);
        } catch (Exception e) {
            return ResultData.fail(401,e.getMessage());
        }
    }

    @GetMapping("/user")
    public String user(){
        return "YES";
    }
}
