package com.shadow.mq.rocketmq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 订阅通道
 */
public interface RocketMQSink {

    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();
}
