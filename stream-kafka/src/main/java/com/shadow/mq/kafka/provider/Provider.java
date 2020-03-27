package com.shadow.mq.kafka.provider;


import com.shadow.mq.kafka.entity.Person;
import com.shadow.mq.kafka.source.KafkaSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Provider {


    @Autowired
    private KafkaSource kafkaSource;


    @GetMapping(value = "/mq/send")
    public String send(){
        Person p = new Person();
        p.setName("王钦");
        p.setAge(18);
        p.setCountry("China");
        p.setLocation("张家界");
        kafkaSource.output().send(
                MessageBuilder.withPayload(p).setHeader("kafka-01",p.getCountry()).build()
        );
        return "kafka";
    }


}
