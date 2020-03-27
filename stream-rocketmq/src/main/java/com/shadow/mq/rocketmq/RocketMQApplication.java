package com.shadow.mq.rocketmq;

import com.shadow.mq.rocketmq.source.RocketMQSink;
import com.shadow.mq.rocketmq.source.RocketMQSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(scanBasePackages = "com.shadow.mq.rocketmq")
@EnableBinding(value = {RocketMQSink.class,RocketMQSource.class})
public class RocketMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQApplication.class,args);
    }
}
