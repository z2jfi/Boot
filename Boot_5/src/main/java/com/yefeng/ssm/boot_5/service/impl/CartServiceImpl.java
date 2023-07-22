package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Cart;
import com.yefeng.ssm.boot_5.service.CartService;
import com.yefeng.ssm.boot_5.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【cart(购物车)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




