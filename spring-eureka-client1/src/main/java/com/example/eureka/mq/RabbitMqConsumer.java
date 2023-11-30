package com.example.eureka.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqConsumer {
    @RabbitListener(queues = {"testQueue"})
    public void receive(@Payload String fileBody) {
        // Stream.of(Thread.currentThread().getStackTrace()).forEach(System.out::println);
        log.info("testQueue：" + fileBody);
    }
}
