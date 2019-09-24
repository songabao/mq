package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author songabao
 * @date 2019-9-24 13:57
 */
@Configuration
public class HelloRabbitmqConfig {
     static final String QUEUE_NAME ="hello";
    @Bean
    public Queue queue(){
        return  new Queue(QUEUE_NAME,true);
    }
}
