package com.yefeng.boot_4.DAO;
import java.util.List;

import com.yefeng.boot_4.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yefeng
* @description 针对表【t_blog】的数据库操作Mapper
* @createDate 2023-05-23 16:49:35
* @Entity com.yefeng.boot_4.pojo.Blog
*/
public interface BlogMapper extends BaseMapper<Blog> {
    int insertSelective(Blog blog);

    List<Blog> selectByUid(@Param("uid") Integer uid);

    List<Blog> selectBlogs();

    int deleteByIdAndUid(@Param("id") Integer id, @Param("uid") Integer uid);

    List<Blog> selectAllByTitle(@Param("title") String title);

    List<Blog> selectAllByTypes(@Param("types") String types);
}




