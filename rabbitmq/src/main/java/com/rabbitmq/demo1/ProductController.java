package com.rabbitmq.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songabao
 * @date 2019-9-24 13:25
 */
@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    static final String QUEUE_NAME ="hello";
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping(value ="send")
    public void send() {
        String message = "HelloWord";
        log.info("发送出去消息："+message);
        rabbitTemplate.convertAndSend(QUEUE_NAME,message);
    }
}
