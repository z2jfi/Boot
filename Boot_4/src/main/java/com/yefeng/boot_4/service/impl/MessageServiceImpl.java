package com.yefeng.boot_4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_4.pojo.Message;
import com.yefeng.boot_4.service.MessageService;
import com.yefeng.boot_4.DAO.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author yefeng
* @description 针对表【t_message】的数据库操作Service实现
* @createDate 2023-05-30 20:43:03
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> addMessage(Message message) {
        int selective = messageMapper.insertSelective(message);
        if (selective > 0){
            List<Message> messageList = messageMapper.selectAll();
            return messageList;
        }else {
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public List<Message> getMessage() {
        return messageMapper.selectAll();
    }
}




