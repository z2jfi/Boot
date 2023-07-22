package com.yefeng.ssm.boot_5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.ssm.boot_5.pojo.Address;
import com.yefeng.ssm.boot_5.service.AddressService;
import com.yefeng.ssm.boot_5.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author yefeng
* @description 针对表【address(收货地址)】的数据库操作Service实现
* @createDate 2023-06-13 10:09:02
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

}




