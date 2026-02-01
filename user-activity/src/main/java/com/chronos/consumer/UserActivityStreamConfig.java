package com.chronos.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Consumer;

@Configuration
public class UserActivityStreamConfig { // Changed class name here

    @Bean
    public Consumer<String> userActivityConsumer() { // Method name stays the same
        return message -> {
            System.out.println("*********** New Message Received ***********");
            System.out.println("Payload: " + message);
            System.out.println("********************************************");
        };
    }
}