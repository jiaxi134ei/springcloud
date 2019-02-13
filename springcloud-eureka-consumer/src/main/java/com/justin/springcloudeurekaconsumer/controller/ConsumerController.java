package com.justin.springcloudeurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    private static final String EUREKA_CLIENT_NAME = "springcloud-eureka-client";
    private static final String EUREKA_CLIENT_METHOD = "/discover";
    private static final String EUREKA_CLIENT_METHOD_A = "/provider";
    @Autowired
    LoadBalancerClient loadBalancerClient; //客户端负载均衡
    @Autowired
    RestTemplate restTemplate;//REST 服务调用
    @GetMapping("/consumer")
    public String consumer() {
        ServiceInstance instance = loadBalancerClient.choose(EUREKA_CLIENT_NAME);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + EUREKA_CLIENT_METHOD;
        String returnStr = restTemplate.getForObject(url,String.class);
        return returnStr;
    }

    @GetMapping("/xiaofei")
    public String xiaofei(@RequestParam String a,@RequestParam String b) {
        ServiceInstance instance = loadBalancerClient.choose(EUREKA_CLIENT_NAME);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + EUREKA_CLIENT_METHOD_A;
        String returnStr = restTemplate.getForObject(url,String.class);
        return returnStr +"xiaofei" + a + b;
    }
}
