package com.danallford.pigeons.app.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = {"login-topic", "dan-topic", "mysql.login"})
    public void listen(String in) {
        //Logic to consume/process message goes here
        System.out.println("MessageConsumer.listen - Received message:" + in);
    }
}