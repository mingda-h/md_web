package com.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
public class DataBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseApplication.class, args);
    }
}
