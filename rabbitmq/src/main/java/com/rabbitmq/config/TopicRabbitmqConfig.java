package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic模式
 * <p>说明：话题模式，给喜欢的用户推荐喜欢的东西</p>
 *    *（星号）可以代替一个单词。
 *   ＃（哈希）可以替代零个或多个单词。
 * @author songabao
 * @date 2019-9-24 14:31
 */
@Configuration
public class TopicRabbitmqConfig {
    public static  final  String TOPIC_QUEUE1= "topic_queue1";
    public static  final  String TOPIC_QUEUE2= "topic_queue2";
    public static  final  String TOPIC_EXCHANGE = "topic_exchange";

    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE1);
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE2);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Binding topicBinding1(){
        return  BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("lzc.message");
    }

    @Bean
    public Binding topicBinding2(){
        return  BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("lzc.*");
    }
}
