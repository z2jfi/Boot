package com.yefeng.boot_2.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yefeng.boot_2.common.results.CommonResult;
import com.yefeng.boot_2.entity.MBlog;
import com.yefeng.boot_2.entity.MUser;
import com.yefeng.boot_2.mapper.MBlogMapper;
import com.yefeng.boot_2.service.MUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Himit_ZH
 * @since 2020-07-19
 */
@RestController
@RequestMapping("/blog/user")
public class MUserController {

    @Autowired
    private MUserService mUserService;

    @Autowired
    private MBlogMapper mBlogService;

    @RequiresAuthentication //需要登录认证才能访问
    @GetMapping("/index")
    public Object test(){
        MUser user = mUserService.getById(1L);
        return CommonResult.successResponse(user, "操作成功");
    }

    @GetMapping("/{username}")
    public CommonResult getUserBlog(@PathVariable("username")String username){
        QueryWrapper<MUser> wrapper1 = new QueryWrapper<MUser>().eq("username", username);

        MUser user = mUserService.getOne(wrapper1);

        if (user==null){
            return  CommonResult.errorResponse("该用户不存在");
        }


        QueryWrapper<MBlog> wrapper2 = new QueryWrapper<MBlog>().eq("user_id", user.getId()).orderByDesc("gmt_create");
        List<MBlog> mBlogs = mBlogService.selectList(wrapper2);
        return  CommonResult.successResponse(mBlogs, "查询成功");
    }


}
