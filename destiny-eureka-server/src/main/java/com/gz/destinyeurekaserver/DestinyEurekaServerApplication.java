package com.gz.destinyeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DestinyEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DestinyEurekaServerApplication.class, args);
    }

}
