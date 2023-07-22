package com.yefeng.boot_4.DAO;
import java.util.List;

import com.yefeng.boot_4.pojo.Help;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yefeng
* @description 针对表【t_help】的数据库操作Mapper
* @createDate 2023-06-01 11:35:11
* @Entity com.yefeng.boot_4.pojo.Help
*/
public interface HelpMapper extends BaseMapper<Help> {
    int insertSelective(Help help);

    Help selectAllByBidAndUid(@Param("bid") Integer bid, @Param("uid") Integer uid);

    List<Help> searchAll();

    List<Help> selectByUid(@Param("uid") Integer uid);

    int updateSelective(Help help);

    int deleteByBid(@Param("bid") Integer bid);

   Help selectAllHelpByUid(int uid);
}




