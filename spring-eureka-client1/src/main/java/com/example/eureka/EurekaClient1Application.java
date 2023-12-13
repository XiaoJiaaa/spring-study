package com.example.eureka;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.*","trace"})
// @EnableFeignClients(basePackages = "api")
@EnableAsync
@EnableRabbit
public class EurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1Application.class, args);
    }

}
