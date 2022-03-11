package com.example.eureka.client;

import api.ClientFeign;
import base.RestResult;
import dto.DemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vo.DemoVO;

@RestController
public class ClientController {

    @GetMapping("/info")
    public String getInfo() {
        return "This is client-1";
    }

    @Autowired
    private ClientFeign clientFeign;

    @GetMapping("/feign/client")
    public RestResult<DemoVO> feignClient(DemoDTO dto) {
        return clientFeign.getClientInfo(dto);
    }

    @PostMapping("/feign/client")
    public RestResult<DemoVO> pofeignClient(@RequestBody DemoDTO dto) {
        return clientFeign.postClientInfo(dto);
    }

    @PutMapping("/feign/client")
    public RestResult<DemoVO> pufeignClient(@RequestBody DemoDTO dto) {
        return clientFeign.putClientInfo(dto);
    }

    @DeleteMapping("/feign/client")
    public RestResult<DemoVO> defeignClient(@SpringQueryMap DemoDTO dto) {
        return clientFeign.deleteClientInfo(dto);
    }
}
