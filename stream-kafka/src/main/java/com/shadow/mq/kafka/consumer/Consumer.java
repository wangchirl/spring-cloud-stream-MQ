package com.shadow.mq.kafka.consumer;

import com.shadow.mq.kafka.entity.Person;
import com.shadow.mq.kafka.source.KafkaSink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {


    @StreamListener(KafkaSink.INPUT)
    public void receive(@Payload Person person){
        System.out.println("Kafka消息====> " + person);
    }

}
