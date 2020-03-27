package com.shadow.mq.kafka;


import com.shadow.mq.kafka.source.KafkaSink;
import com.shadow.mq.kafka.source.KafkaSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(scanBasePackages = "com.shadow.mq.kafka")
@EnableBinding(value = {KafkaSink.class,KafkaSource.class})
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }
}
