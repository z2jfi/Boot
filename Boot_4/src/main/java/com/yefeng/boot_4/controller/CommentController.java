package com.yefeng.boot_4.controller;

import com.yefeng.boot_4.common.JsonResult;
import com.yefeng.boot_4.common.ResultCode;
import com.yefeng.boot_4.common.ResultUtil;
import com.yefeng.boot_4.pojo.Comment;
import com.yefeng.boot_4.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/addComment")
    public JsonResult<List<Comment>> AddComment(@RequestBody Comment comment){
        List<Comment> commentList = commentService.addComment(comment);

        return ResultUtil.success(commentList,ResultCode.SUCCESS);
    }

    @GetMapping("/getComments/{bid}")
    public JsonResult<List<Comment>> getComments(@PathVariable("bid") int bid){
        List<Comment> commentList = commentService.getCommentList(bid);
        return ResultUtil.success(commentList,ResultCode.SUCCESS);
    }

    @GetMapping("/getCommentTotal")
    private JsonResult<List<Comment>> getCommentTotal(){
        List<Comment> totalComm = commentService.getTotalComm();
        return ResultUtil.success(totalComm,ResultCode.SUCCESS);
    }
}
