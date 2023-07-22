package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Order;
import com.yefeng.ssm.boot_5.service.OrderService;
import com.yefeng.ssm.boot_5.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【t_order(订单表)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




