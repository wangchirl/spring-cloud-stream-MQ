package com.shadow.mq.rocketmq.provider;


import com.shadow.mq.rocketmq.entity.Car;
import com.shadow.mq.rocketmq.source.RocketMQSource;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 消息提供者
 */
@RestController
public class Provider {


    @Autowired
    private RocketMQSource rocketMQSource;

    @GetMapping("/mq/send")
    public String send(){
        Car car = new Car();
        car.setName("红旗");
        car.setColor("red");
        car.setPrice(new BigDecimal(20000000));
        rocketMQSource.output().send(MessageBuilder.withPayload(car).build());
        return "rocketmq";
    }

}
