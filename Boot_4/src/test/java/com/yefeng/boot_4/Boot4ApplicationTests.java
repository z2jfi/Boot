package com.yefeng.boot_4;

import com.yefeng.boot_4.DAO.HelpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Boot4ApplicationTests {

    @Resource
    private HelpMapper helpMapper;

    @Test
    void contextLoads() {


    }


}
