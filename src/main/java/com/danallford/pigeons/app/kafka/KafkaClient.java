package com.danallford.pigeons.app.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

//@SpringBootApplication
@RestController
public class KafkaClient {

    @Autowired
    Environment env;

    @Autowired
    MessageProducer messageProducer;

//    public static void main(String[] args) {
//
//        SpringApplication.run(KafkaClientApp.class, args);
//    }

    @PostMapping("/notify")
    public String sendNotificationPost(@RequestBody String message) {
        System.out.println("sendNotificationPost - sending message : " + message);
        messageProducer.send(message);
        System.out.println("sendNotificationPost - sent message : " + message);
        return "'" + message + "' has been sent.";
    }

    @GetMapping("/notify")
    public String sendNotificationGet(@RequestParam(name = "message") String message) {
        System.out.println("sendNotificationGet - sending message : " + message);
        messageProducer.send(message);
        System.out.println("sendNotificationGet - sent message : " + message);
        return "'" + message + "' has been sent.";
    }

}
