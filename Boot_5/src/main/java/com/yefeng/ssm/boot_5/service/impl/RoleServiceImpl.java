package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Role;
import com.yefeng.ssm.boot_5.service.RoleService;
import com.yefeng.ssm.boot_5.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【t_role(角色表)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




