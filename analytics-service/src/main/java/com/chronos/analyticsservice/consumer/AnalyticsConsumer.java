package com.chronos.analyticsservice.consumer;

import com.chronos.common.dto.UserEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AnalyticsConsumer {
    @Bean
    public Consumer<UserEvent> userActivityConsumer(){
        return userEvent -> {
            System.out.println("Processing User: " + userEvent.userId());
        };
    }
}
