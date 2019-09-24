package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>订阅模式</p>
 * @author songabao
 * @date 2019-9-24 15:46
 */
@Configuration
public class FanoutRabbitmqConfig {
    public static  final  String FANOUT_QUEUE1= "fanout_queue1";
    public static  final  String FANOUT_QUEUE2= "fanout_queue2";
    public static  final  String FANOUT_EXCHANGE = "fanout_exchange";

    @Bean
    public Queue fanoutQueue1(){
        return new Queue(FANOUT_QUEUE1);
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue(FANOUT_QUEUE2);
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }
    @Bean
    public Binding fanoutBinding1(){
        return  BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2(){
        return  BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
}
