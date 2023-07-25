package com.huangqi.edustatistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.huangqi"})
@EnableFeignClients
@EnableDiscoveryClient
@EnableScheduling
@MapperScan("com.huangqi.edustatistics.mapper")
public class EduStatisticsAplication {
    public static void main(String[] args) {
        SpringApplication.run(EduStatisticsAplication.class, args);
    }
}

