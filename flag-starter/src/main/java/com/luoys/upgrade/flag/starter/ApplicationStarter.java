package com.luoys.upgrade.flag.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBootApplication：启动类注解，包含三个主要功能
 * EnableScheduling：启动定时任务
 * ComponentScan：扫描指定包路径下的所有文件
 * MapperScan：扫描Mapper
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.luoys.upgrade.flag")
@MapperScan("com.luoys.upgrade.flag.dao")
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
