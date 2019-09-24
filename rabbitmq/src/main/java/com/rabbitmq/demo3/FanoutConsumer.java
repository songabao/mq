package com.rabbitmq.demo3;

import com.rabbitmq.config.FanoutRabbitmqConfig;
import com.rabbitmq.entiy.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author songabao
 * @date 2019-9-24 15:07
 */
@Component
public class FanoutConsumer {
    private static  final Logger log = LoggerFactory.getLogger(FanoutConsumer.class);
    @RabbitListener(queues = FanoutRabbitmqConfig.FANOUT_QUEUE1)
    public void queue1(String user){
        log.info("接收queue1的消息是："+user);
    }
    @RabbitListener(queues = FanoutRabbitmqConfig.FANOUT_QUEUE2)
    public void queue2(String user){
        log.info("接收queue2的消息是："+user);
    }
}
