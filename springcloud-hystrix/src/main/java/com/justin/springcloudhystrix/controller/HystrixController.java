package com.justin.springcloudhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class HystrixController {

    @Autowired
    ConsumerService consumerService;
    @GetMapping("/dis")
    public String discover() throws Exception{
        Thread.sleep(50000);
        return consumerService.consumer();
    }




    @Service
    class ConsumerService {
        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer() {
            return restTemplate.getForObject("http://springcloud-eureka-client/discover",String.class);
        }

        public String fallback() {
            return "fallback";
        }
    }
}
