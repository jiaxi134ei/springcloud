package com.justin.springclouderuekafeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudEruekaFeignApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringcloudEruekaFeignApplication.class, args);

        new SpringApplicationBuilder(SpringcloudEruekaFeignApplication.class)
                .web(true).run(args);
    }


}

