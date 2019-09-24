package com.rabbitmq.demo3;

import com.rabbitmq.config.FanoutRabbitmqConfig;
import com.rabbitmq.entiy.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songabao
 * @date 2019-9-24 15:50
 */
@RestController
public class FanoutProducer {
    private static final Logger log = LoggerFactory.getLogger(FanoutProducer.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping(value = "fanout")
    public void fanout(){
        User user = new User(1, "aaa");
        rabbitTemplate.convertAndSend(FanoutRabbitmqConfig.FANOUT_EXCHANGE,"",user.toString());
    }
}
