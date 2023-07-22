package com.yefeng.boot_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Boot4Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot4Application.class, args);
    }
}
