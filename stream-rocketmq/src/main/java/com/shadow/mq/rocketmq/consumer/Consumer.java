package com.shadow.mq.rocketmq.consumer;


import com.shadow.mq.rocketmq.entity.Car;
import com.shadow.mq.rocketmq.source.RocketMQSink;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class Consumer {

    /**
     * @StreamListener 消息监听
     * @Payload 取到消息体内容
     * @Header 可以取到消息提供者提供的header
     * @param car
     */
    @StreamListener(RocketMQSink.INPUT)
    public void receive(@Payload Car car){
        System.out.println("rocketMQ消息====> " + car );
    }

}
