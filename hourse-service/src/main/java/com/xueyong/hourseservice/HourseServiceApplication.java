package com.xueyong.hourseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@SpringBootApplication
public class HourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HourseServiceApplication.class, args);
    }

}
