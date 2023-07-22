package com.yefeng.boot_4.controller;

import com.yefeng.boot_4.common.JsonResult;
import com.yefeng.boot_4.common.ResultCode;
import com.yefeng.boot_4.common.ResultUtil;
import com.yefeng.boot_4.pojo.Blog;
import com.yefeng.boot_4.pojo.Log;
import com.yefeng.boot_4.pojo.Typs;
import com.yefeng.boot_4.service.BlogService;
import com.yefeng.boot_4.service.LogService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
  @Resource
  private BlogService blogService;

  @Resource
  private LogService logService;

  @PostMapping("/release")
  public JsonResult<String> ReleaseBlog(@RequestBody Blog blog){
      List<Blog> blogList = blogService.addBlog(blog);
      if (blogList.size() > 0){
          Log log = new Log();
          log.setUid(blog.getUid());
          log.setContent("发表文章");
          log.setDate(new Date());
          logService.addLog(log);
      }
      return ResultUtil.successNoData(ResultCode.SUCCESS);
  }

  @GetMapping("/getBlogs")
  public JsonResult<List<Blog>> getBlogs(){
      List<Blog> blogList = blogService.getBlogs();
      return ResultUtil.success(blogList,ResultCode.SUCCESS);
  }

  @GetMapping("/getuserblog/{uid}")
  public JsonResult<List<Blog>> getUserBlog(@PathVariable("uid") int uid){
      List<Blog> blogsByUid = blogService.getBlogsByUid(uid);
      return ResultUtil.success(blogsByUid,ResultCode.SUCCESS);
  }

  @DeleteMapping("/deleteUserBlog/{uid}/{index}")
  public JsonResult<List<Blog>> DeleteUserBlog(@PathVariable("uid") int uid, @PathVariable("index") int index){
      List<Blog> blogList = null;
      try {
          blogList = blogService.deleteBlog(index, uid);
          return ResultUtil.success(blogList,ResultCode.SUCCESS);
      } catch (Exception e) {
          return ResultUtil.faile(ResultCode.FAILURE);
      }
  }

  @GetMapping("/SearchBlog/{title}")
  public JsonResult<List<Blog>> getSearchBlog(@PathVariable("title") String title){
      List<Blog> searchBlogs = blogService.getSearchBlogs(title);
      if (searchBlogs.size() != 0){
          return ResultUtil.success(searchBlogs,ResultCode.SUCCESS);
      }
      return ResultUtil.faile(ResultCode.FAILURE);
  }

  @GetMapping("/getTypes")
  public JsonResult<List<Typs>> getTypes(){
      List<Typs> typsList = blogService.getTypes();
      return ResultUtil.success(typsList,ResultCode.SUCCESS);
  }

  @GetMapping("/getTypeBlog/{type}")
  public JsonResult<List<Blog>> getTypeBlog(@PathVariable("type") String type){
      List<Blog> typeBlog = blogService.getTypeBlog(type);
      return ResultUtil.success(typeBlog,ResultCode.SUCCESS);
  }

}
