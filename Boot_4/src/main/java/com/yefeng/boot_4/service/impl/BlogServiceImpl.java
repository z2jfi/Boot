package com.yefeng.boot_4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.boot_4.DAO.CommentMapper;
import com.yefeng.boot_4.DAO.HelpMapper;
import com.yefeng.boot_4.DAO.TypsMapper;
import com.yefeng.boot_4.pojo.Blog;
import com.yefeng.boot_4.pojo.Typs;
import com.yefeng.boot_4.service.BlogService;
import com.yefeng.boot_4.DAO.BlogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 * @description 针对表【t_blog】的数据库操作Service实现
 * @createDate 2023-05-23 16:49:35
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService{

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private TypsMapper typsMapper;

    @Resource
    private HelpMapper helpMapper;

    @Resource
    private CommentMapper commentMapper;

    public List<Blog> addBlog(Blog blog){
        int insertSelective = blogMapper.insertSelective(blog);
        if (insertSelective > 0){
            return blogMapper.selectByUid(blog.getUid());
        }else {
            throw new RuntimeException("添加失败");
        }
    }

    public List<Blog> getBlogs(){
        return blogMapper.selectBlogs();
    }

    @Override
    public List<Blog> getBlogsByUid(int uid) {

        List<Blog> blogList = blogMapper.selectByUid(uid);

        return blogList;
    }

    @Override
    @Transactional
    public List<Blog> deleteBlog(int id, int uid) {
        List<Blog> blogArrayList = new ArrayList<>();
        int byIdAndUid = 0;
        try {
            int deleteByBid = helpMapper.deleteByBid(id);
            int deleteByBid1 = commentMapper.deleteByBid(id);
            byIdAndUid = blogMapper.deleteByIdAndUid(id, uid);
        } catch (Exception e) {
            throw new RuntimeException("删除失败");
        }
        if (byIdAndUid > 0){
            blogArrayList = blogMapper.selectByUid(uid);
        }
        return blogArrayList;
    }

    @Override
    public List<Blog> getSearchBlogs(String title) {
        List<Blog> blogList = blogMapper.selectAllByTitle(title);
        return blogList;
    }

    @Override
    public List<Typs> getTypes() {
        return typsMapper.selectAll();
    }

    @Override
    public List<Blog> getTypeBlog(String types) {
        return blogMapper.selectAllByTypes(types);
    }
}





