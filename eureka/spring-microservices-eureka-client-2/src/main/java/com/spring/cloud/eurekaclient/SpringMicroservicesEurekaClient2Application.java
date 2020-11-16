package com.spring.cloud.eurekaclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@AllArgsConstructor
public class SpringMicroservicesEurekaClient2Application {

    private final EurekaClient client;

    @GetMapping("/serviceinfo")
    public String serviceInfo(){
        InstanceInfo info = client.getNextServerFromEureka("eureka-client-2", false);
        return info.getHomePageUrl();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMicroservicesEurekaClient2Application.class, args);
    }

}
