package com.justin.springclouderuekafeign.controller;

import com.justin.springclouderuekafeign.service.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    FeignClient feignClient;
    @GetMapping("/feign")
    public String feign() {
        return feignClient.feign();
    }
}
