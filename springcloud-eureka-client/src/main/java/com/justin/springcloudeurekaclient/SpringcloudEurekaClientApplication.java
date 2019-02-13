package com.justin.springcloudeurekaclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudEurekaClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringcloudEurekaClientApplication.class)
                .web(true).run(args);
    }

}

