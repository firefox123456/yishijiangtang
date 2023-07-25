package com.huangqi.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = {"com.huangqi"})
@SpringBootApplication
@EnableWebMvc
@EnableDiscoveryClient//nacos注册
@EnableFeignClients//openfeign
public class EduApplication  {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
