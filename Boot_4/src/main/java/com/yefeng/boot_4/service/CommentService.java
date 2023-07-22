package com.yefeng.boot_4.service;

import com.yefeng.boot_4.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yefeng
* @description 针对表【t_comment】的数据库操作Service
* @createDate 2023-06-01 16:15:21
*/
public interface CommentService extends IService<Comment> {
    List<Comment> addComment(Comment comment);

    List<Comment> getCommentList(int bid);

    List<Comment> getTotalComm();
}
