package com.yefeng.boot_4.DAO;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.boot_4.pojo.Log;

/**
* @author yefeng
* @description 针对表【t_log】的数据库操作Mapper
* @createDate 2023-05-31 19:19:43
* @Entity com.yefeng.boot_4.pojo.Log
*/
public interface LogMapper extends BaseMapper<Log> {

    int insertSelective(Log log);

    List<Log> selectAll();
}




