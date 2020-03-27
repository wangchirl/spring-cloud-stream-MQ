package com.shadow.mq.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息接收通道
 */
public interface RabbitMQSink {

    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();
}
