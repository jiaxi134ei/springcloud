package com.justin.springcloudeurekaribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    private static final String Eureka_Server_Provider = "http://springcloud-eureka-client/discover";
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/ribbon")
    public String ribbon() {
        return restTemplate.getForObject(Eureka_Server_Provider,String.class);
    }
}
