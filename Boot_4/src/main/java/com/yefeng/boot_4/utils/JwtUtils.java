package com.yefeng.boot_4.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yefeng.boot_4.pojo.User;

import java.util.Date;

public class JwtUtils {

    public static final long EXPIRE_TIME = 60L* 60 * 1000*25*365;

    public static final String SECRET = "SECRET%$#";

    //签发token
    public static String getToken(User user){
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("root", user.getRoot())
                .withClaim("state", user.getState())
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    //校验token
    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT  = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //获取token内的携带的用户名信息
    public static User getUserNameByToken(String token){
        User user = new User();
        DecodedJWT decodedJWT = JWT.decode(token);
         user.setId(decodedJWT.getClaim("id").asInt());
         user.setUsername( decodedJWT.getClaim("username").asString());
         user.setRoot(decodedJWT.getClaim("root").asInt());
         user.setState(decodedJWT.getClaim("state").asInt());
         return user;
    }
}
