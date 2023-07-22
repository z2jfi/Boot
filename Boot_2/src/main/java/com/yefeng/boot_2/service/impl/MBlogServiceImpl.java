package com.yefeng.boot_2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_2.entity.MBlog;
import com.yefeng.boot_2.mapper.MBlogMapper;
import com.yefeng.boot_2.service.MBlogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Himit_ZH
 * @since 2020-07-19
 */
@Service
public class MBlogServiceImpl extends ServiceImpl<MBlogMapper, MBlog> implements MBlogService {

}
