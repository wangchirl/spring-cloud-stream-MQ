package com.shadow.mq.rabbitmq;


import com.shadow.mq.rabbitmq.source.RabbitMQSink;
import com.shadow.mq.rabbitmq.source.RabbitMQSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(scanBasePackages = "com.shadow.mq.rabbitmq")
@EnableBinding(value = {RabbitMQSink.class, RabbitMQSource.class})
public class RabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }

}
