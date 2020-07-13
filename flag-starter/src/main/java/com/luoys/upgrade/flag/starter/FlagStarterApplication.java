package com.luoys.upgrade.flag.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.luoys.upgrade.flag")
@MapperScan("com.luoys.upgrade.flag.dao")
public class FlagStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlagStarterApplication.class, args);
    }

}