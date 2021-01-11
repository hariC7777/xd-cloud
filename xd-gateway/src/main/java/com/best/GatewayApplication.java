package com.best;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: Hari
 * @Date: 2021/1/7 14:07
 * @Description:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String [] args){
        SpringApplication.run(GatewayApplication.class,args);
    }

}
