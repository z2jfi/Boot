package com.yefeng.boot_2.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yefeng.boot_2.common.dto.LoginDto;
import com.yefeng.boot_2.common.dto.RegisterDto;
import com.yefeng.boot_2.common.results.CommonResult;
import com.yefeng.boot_2.entity.MUser;
import com.yefeng.boot_2.mapper.MUserMapper;
import com.yefeng.boot_2.service.MUserService;
import com.yefeng.boot_2.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Himit_ZH
 * @Date: 2020/7/20 00:25
 * @Description:
 */
@RestController
public class AccountController {

    @Autowired
    MUserMapper userServiceDao;

    @Autowired
    MUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public CommonResult register(@Validated @RequestBody RegisterDto registerDto, HttpServletResponse response){
        QueryWrapper<MUser> wrapper = new QueryWrapper<MUser>().eq("username", registerDto.getUsername());
        MUser user = userService.getOne(wrapper);
        if(user!=null){
            return CommonResult.errorResponse("注册失败,该用户名已被使用");
        }
        int insert = userServiceDao.insert(new MUser().setEmail(registerDto.getEmail())
                .setUsername(registerDto.getUsername())
                .setPassword(SecureUtil.md5(registerDto.getPassword())));
        if (insert == 1) {
            // 用户可以另一个接口
            return CommonResult.successResponse(null, "注册成功");
        }else{
            return CommonResult.errorResponse("注册失败");
        }
    }

    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        QueryWrapper<MUser> wrapper = new QueryWrapper<MUser>().eq("username", loginDto.getUsername());
        MUser user = userService.getOne(wrapper);
        Assert.notNull(user,"用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return CommonResult.errorResponse("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt); //放到信息头部
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        return CommonResult.successResponse(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map(),"登录成功"
        );
    }

    // 退出
    @GetMapping("/logout")
    @RequiresAuthentication
    public CommonResult logout() {
        SecurityUtils.getSubject().logout();
        return CommonResult.successResponse(null,"退出成功");

    }

}