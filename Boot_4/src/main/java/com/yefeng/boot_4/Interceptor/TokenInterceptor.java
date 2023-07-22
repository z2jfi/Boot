package com.yefeng.boot_4.Interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yefeng.boot_4.DAO.UserMapper;
import com.yefeng.boot_4.pojo.User;
import com.yefeng.boot_4.utils.JwtUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

       if (StringUtils.isBlank(token)){
           throw new RuntimeException("无token，请重新登录");
       }

       if (JwtUtils.verify(token)){
           User user = JwtUtils.getUserNameByToken(token);
           List<User> users = userMapper.selectByUsername(user.getUsername());
           if (users.size() == 0){
               throw new RuntimeException("用户不存在，请重新登录");
           }
       }else {
           throw new RuntimeException("token已过期，请重新登录");
       }

       return true;

    }
}
