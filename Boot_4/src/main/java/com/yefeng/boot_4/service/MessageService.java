package com.yefeng.boot_4.service;

import com.yefeng.boot_4.pojo.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yefeng
* @description 针对表【t_message】的数据库操作Service
* @createDate 2023-05-30 20:43:03
*/
public interface MessageService extends IService<Message> {
   List<Message> addMessage(Message message);

   List<Message> getMessage();
}
