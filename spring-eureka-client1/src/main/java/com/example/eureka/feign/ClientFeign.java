package com.example.eureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client2")
@Component
public interface ClientFeign {
    @GetMapping("info")
    String getClientInfo();

}
