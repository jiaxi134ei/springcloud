package com.justin.springclouderuekafeign.service;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.netflix.feign.FeignClient("springcloud-eureka-client")
public interface FeignClient {
    @GetMapping("/discover")
    public String feign();
}
