package com.gz.destinylegends;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
@MapperScan("com.gz.destinylegends.mapper")
public class DestinyLegendsApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(DestinyLegendsApplication.class, args);
        log.info("启动项目耗时:{}ms", System.currentTimeMillis() - start);
    }

}
