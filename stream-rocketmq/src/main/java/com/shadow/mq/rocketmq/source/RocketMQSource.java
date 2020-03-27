package com.shadow.mq.rocketmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 发送通道
 */
public interface RocketMQSource {

    String OUTPUT = "output";

    @Output("output")
    MessageChannel output();
}
