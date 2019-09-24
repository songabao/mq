package com.rabbitmq.demo2;

import com.rabbitmq.config.TopicRabbitmqConfig;
import com.rabbitmq.entiy.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songabao
 * @date 2019-9-24 14:56
 */
@RestController
public class TopicProducer {
    private static  final Logger log = LoggerFactory.getLogger(TopicProducer.class);
    @Autowired
    private RabbitTemplate rabbit;
    @GetMapping(value = "topic")
    public void topic(){
        User user = new User(1, "aaa");
        User user2 = new User(2, "bbb");
        log.info("------------------------------------------------------------------");
        log.info("发送消息");
        log.info("------------------------------------------------------------------");
        rabbit.convertAndSend(TopicRabbitmqConfig.TOPIC_EXCHANGE,"lzc.message",user.toString());
        rabbit.convertAndSend(TopicRabbitmqConfig.TOPIC_EXCHANGE,"lzc.lzc",user2.toString());
    }
}
