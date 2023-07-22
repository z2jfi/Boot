package com.yefeng.boot_4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_4.pojo.Comment;
import com.yefeng.boot_4.service.CommentService;
import com.yefeng.boot_4.DAO.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author yefeng
* @description 针对表【t_comment】的数据库操作Service实现
* @createDate 2023-06-01 16:15:21
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> addComment(Comment comment) {
        int insertSelective = commentMapper.insertSelective(comment);
        if (insertSelective == 0){
            throw new RuntimeException("评价失败");
        }
        return getCommentList(comment.getBid());
    }

    @Override
    public List<Comment> getCommentList(int bid) {
        return commentMapper.selectAllByBid(bid);
    }

    @Override
    public List<Comment> getTotalComm() {
        return commentMapper.selectCommentTotal();
    }
}




