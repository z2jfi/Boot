package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Goods;
import com.yefeng.ssm.boot_5.service.GoodsService;
import com.yefeng.ssm.boot_5.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【goods(商品)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




