package com.yefeng.boot_4.DAO;
import java.util.List;

import com.yefeng.boot_4.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yefeng
* @description 针对表【t_comment】的数据库操作Mapper
* @createDate 2023-06-01 16:15:21
* @Entity com.yefeng.boot_4.pojo.Comment
*/
public interface CommentMapper extends BaseMapper<Comment> {
    int insertSelective(Comment comment);

    List<Comment> selectAllByBid(@Param("bid") Integer bid);

    List<Comment> selectCommentTotal();

    int deleteByBid(@Param("bid") Integer bid);
}




