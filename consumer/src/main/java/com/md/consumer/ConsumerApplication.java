package com.md.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableEurekaClient
@SpringBootApplication
//使用该注解扫描整个项目的Feign
@EnableFeignClients(basePackages = {"com.md"})
//扫描整个包的bean
@ComponentScan(basePackages = {"com.md"})
//@EnableUserInfoTransmitter
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
