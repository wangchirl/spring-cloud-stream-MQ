package com.shadow.mq.rabbitmq.consumer;

import com.shadow.mq.rabbitmq.entity.User;
import com.shadow.mq.rabbitmq.source.RabbitMQSink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class Consumer {

    @StreamListener(RabbitMQSink.INPUT)
    public void receive(@Payload User user){
        System.out.println("接收到MQ消息===> " + user);
    }

}
