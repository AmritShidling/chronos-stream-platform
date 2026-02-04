package com.chronos.analyticsservice.consumer;

import com.chronos.common.dto.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class AnalyticsConsumer {
    @Bean
    public Consumer<UserEvent> userActivityConsumer(){
        return userEvent -> {
            System.out.println("*********** New Message Received ***********");
            System.out.println("Payload: " + userEvent);
            System.out.println("********************************************");
        };
    }
}
