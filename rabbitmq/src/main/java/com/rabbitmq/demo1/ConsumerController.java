package com.rabbitmq.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author songabao
 * @date 2019-9-24 14:09
 */
@Component
public class ConsumerController {
    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);
    static final String QUEUE_NAME ="hello";
    @RabbitListener(queues = QUEUE_NAME)
    public void consumer(String message){
        log.info("接收到的消息："+message);
    }
}
