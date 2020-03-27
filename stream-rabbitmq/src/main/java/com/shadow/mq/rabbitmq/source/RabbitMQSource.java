package com.shadow.mq.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息发送通道
 */
public interface RabbitMQSource {

    String OUTPUT = "output";

    @Output("output")
    MessageChannel output();

}
