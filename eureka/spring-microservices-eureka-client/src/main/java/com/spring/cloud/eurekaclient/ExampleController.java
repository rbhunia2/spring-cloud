package com.spring.cloud.eurekaclient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class ExampleController {

    private final RestTemplate restTemplate;

    @GetMapping("/execute")
    public String execute(){
        return restTemplate.getForObject("http://EUREKA-CLIENT-2/serviceinfo", String.class);
    }
}
