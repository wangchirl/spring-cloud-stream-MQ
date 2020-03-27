package com.shadow.mq.rabbitmq.provider;

import com.shadow.mq.rabbitmq.entity.User;
import com.shadow.mq.rabbitmq.source.RabbitMQSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息提供者
 */
@RestController
public class Provider {

    @Autowired
    private RabbitMQSource rabbitMQSource;

    @GetMapping(value = "/mq/send")
    public String sendMsg(){
        User user = new User();
        user.setName("王钦");
        user.setAge(19);
        rabbitMQSource.output().send(MessageBuilder.withPayload(user)
                .setHeader("rabbitmq-01", user.getName())
                .build());

        return "rabbitmq";
    }

}
