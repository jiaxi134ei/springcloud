package com.justin.springcloudeurekaclient.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/discover")
    public String discover() {
        return "SpringCloud Server Provider Discover Method ...";
    }
    @GetMapping("/provider")
    public String provider() {
        return "SpringCloud Server Provider Provider Method ===";
    }
}
