package com.luoys.flagstarter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.luoys.flag")
@MapperScan("com.luoys.flag.dao")
public class FlagStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlagStarterApplication.class, args);
    }

}
