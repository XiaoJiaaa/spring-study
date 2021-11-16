package com.example.eureka.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/info")
    public String getInfo() {
        return "This is client-1";
    }

}
