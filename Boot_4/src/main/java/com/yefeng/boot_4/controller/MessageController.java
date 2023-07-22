package com.yefeng.boot_4.controller;

import com.yefeng.boot_4.common.JsonResult;
import com.yefeng.boot_4.common.ResultCode;
import com.yefeng.boot_4.common.ResultUtil;
import com.yefeng.boot_4.pojo.Message;
import com.yefeng.boot_4.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @PostMapping("/addMessageBlog")
    private JsonResult<List<Message>> addMessageBlog(@RequestBody Message message){
        List<Message> messageList = messageService.addMessage(message);
        return ResultUtil.success(messageList,ResultCode.SUCCESS);
    }

    @GetMapping("/getMessageBlog")
    private JsonResult<List<Message>> getMessageBlog(){
        List<Message> messageList = messageService.getMessage();
        return ResultUtil.success(messageList,ResultCode.SUCCESS);
    }
}
