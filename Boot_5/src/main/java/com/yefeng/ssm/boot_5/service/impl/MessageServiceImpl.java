package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Message;
import com.yefeng.ssm.boot_5.service.MessageService;
import com.yefeng.ssm.boot_5.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【t_message(留言表)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




