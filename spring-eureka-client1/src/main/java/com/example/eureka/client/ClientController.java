package com.example.eureka.client;

import com.example.eureka.feign.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/info")
    public String getInfo() {
        return "This is client-1";
    }

    @Autowired
    private ClientFeign clientFeign;

    @GetMapping("/feign/client")
    public String feignClient() {
        return clientFeign.getClientInfo();
    }
}
