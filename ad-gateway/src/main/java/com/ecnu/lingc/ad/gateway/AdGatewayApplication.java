package com.ecnu.lingc.ad.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/25 21:34
 * @Author: Ling Chen
 * @Description:
 */
@EnableZuulProxy
@SpringCloudApplication
public class AdGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdGatewayApplication.class, args);
    }
}
