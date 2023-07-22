package com.yefeng.boot_4.DAO;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.boot_4.pojo.Message;

/**
* @author yefeng
* @description 针对表【t_message】的数据库操作Mapper
* @createDate 2023-05-30 20:43:03
* @Entity com.yefeng.boot_4.pojo.Message
*/
public interface MessageMapper extends BaseMapper<Message> {
    int insertSelective(Message message);

    List<Message> selectAll();
}




