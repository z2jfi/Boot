package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Notice;
import com.yefeng.ssm.boot_5.service.NoticeService;
import com.yefeng.ssm.boot_5.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【t_notice】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




