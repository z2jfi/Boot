package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Category;
import com.yefeng.ssm.boot_5.service.CategoryService;
import com.yefeng.ssm.boot_5.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【category(商品分类)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




