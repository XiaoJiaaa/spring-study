package com.example.eureka.client;

import api.ClientFeign;
import base.RestResult;
import com.example.eureka.mq.RabbitConfig;
import dto.DemoDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vo.DemoVO;

import java.lang.reflect.Type;
import java.util.UUID;

@RestController
public class ClientController {

    @GetMapping("/info")
    public String getInfo() {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(){
            @Override
            protected Message createMessage(Object objectToConvert, MessageProperties messageProperties) throws MessageConversionException {
                messageProperties.setHeader("requestId",objectToConvert.toString());
                return super.createMessage(objectToConvert, messageProperties);
            }

            @Override
            protected Message createMessage(Object objectToConvert, MessageProperties messageProperties, Type genericType) throws MessageConversionException {
                messageProperties.setHeader("requestId",objectToConvert.toString());
                return super.createMessage(objectToConvert, messageProperties, genericType);
            }
        });
rabbitTemplate.convertAndSend(myQueue.getName(), UUID.randomUUID().toString());
        return "This is client-1";
    }

    // @Autowired
    private ClientFeign clientFeign;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue myQueue;



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
        RabbitConfig rabbitConfig = new RabbitConfig();
        Class<?>[] interfaces = rabbitConfig.getClass().getInterfaces();
        return clientFeign.deleteClientInfo(dto);
    }
}
