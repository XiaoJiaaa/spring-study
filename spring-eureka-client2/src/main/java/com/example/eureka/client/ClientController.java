package com.example.eureka.client;

import base.RestResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DemoDTO;
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
    private static final ObjectMapper obj = new ObjectMapper();

    @GetMapping("/info")
    public RestResult<DemoVO> getInfo(@SpringQueryMap DemoDTO dto) throws JsonProcessingException {
        DemoVO demoVO = new DemoVO();
        demoVO.setInfo(obj.writeValueAsString(dto));

        RestResult<DemoVO> result = new RestResult<>();
        result.setCode("200");
        result.setMessage("This is client-2 get method");
        result.setData(demoVO);
        return result;
    }

    @PostMapping("/info")
    public RestResult<DemoVO> postInfo(@RequestBody DemoDTO dto) throws JsonProcessingException {
        DemoVO demoVO = new DemoVO();
        demoVO.setInfo(obj.writeValueAsString(dto));

        RestResult<DemoVO> result = new RestResult<>();
        result.setCode("201");
        result.setMessage("This is client-2 post method");
        result.setData(demoVO);
        return result;
    }

    @PutMapping("/info")
    public RestResult<DemoVO> putInfo(@RequestBody DemoDTO dto) throws JsonProcessingException {
        DemoVO demoVO = new DemoVO();
        demoVO.setInfo(obj.writeValueAsString(dto));

        RestResult<DemoVO> result = new RestResult<>();
        result.setCode("202");
        result.setMessage("This is client-2 put method");
        result.setData(demoVO);
        return result;
    }

    @DeleteMapping("/info")
    public RestResult<DemoVO> deleteInfo(@SpringQueryMap DemoDTO dto) throws JsonProcessingException {
        DemoVO demoVO = new DemoVO();
        demoVO.setInfo(obj.writeValueAsString(dto));

        RestResult<DemoVO> result = new RestResult<>();
        result.setCode("203");
        result.setMessage("This is client-2 delete method");
        result.setData(demoVO);
        return result;
    }

}
