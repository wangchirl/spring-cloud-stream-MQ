package com.shadow.mq.kafka.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaSink {

    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();

}
