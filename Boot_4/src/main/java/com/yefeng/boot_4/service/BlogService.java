package com.yefeng.boot_4.service;

import com.yefeng.boot_4.pojo.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yefeng.boot_4.pojo.Typs;

import java.util.List;

/**
 * @author yefeng
 * @description 针对表【t_blog】的数据库操作Service
 * @createDate 2023-05-23 16:49:35
 */
public interface BlogService extends IService<Blog> {
    List<Blog> addBlog(Blog blog);
    List<Blog> getBlogs();

    List<Blog> getBlogsByUid(int uid);

    List<Blog> deleteBlog(int id,int uid);

    List<Blog> getSearchBlogs(String title);

    List<Typs> getTypes();

    List<Blog> getTypeBlog(String types);
}
