package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.OrderGoods;
import com.yefeng.ssm.boot_5.service.OrderGoodsService;
import com.yefeng.ssm.boot_5.mapper.OrderGoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【order_goods(订单商品关系表)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper, OrderGoods>
    implements OrderGoodsService{

}




