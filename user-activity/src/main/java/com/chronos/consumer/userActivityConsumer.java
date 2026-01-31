package com.chronos.consumer;

import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

public class userActivityConsumer {
    @Bean
    public Consumer<String> userActivityConsumer(){
        return message -> {
            System.out.println("*********** New Message Received ***********");
            System.out.println("Payload: " + message);
            System.out.println("********************************************");
        };
    }
}
