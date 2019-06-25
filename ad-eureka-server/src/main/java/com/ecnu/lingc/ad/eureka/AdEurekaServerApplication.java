package com.ecnu.lingc.ad.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/24 22:26
 * @Author: Ling Chen
 * @Description:
 */

@EnableEurekaServer
@SpringBootApplication
public class AdEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdEurekaServerApplication.class, args);
    }
}
