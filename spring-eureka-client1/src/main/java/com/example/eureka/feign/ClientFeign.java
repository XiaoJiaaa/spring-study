package com.example.eureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client2")
public interface ClientFeign {
    @GetMapping("/info")
    String getClientInfo();

}
