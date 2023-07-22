package com.yefeng.boot_4.DAO;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.boot_4.pojo.Typs;

/**
* @author yefeng
* @description 针对表【t_typs】的数据库操作Mapper
* @createDate 2023-05-30 14:36:45
* @Entity com.yefeng.boot_4.pojo.Typs
*/
public interface TypsMapper extends BaseMapper<Typs> {

    List<Typs> selectAll();

}




