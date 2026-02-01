package com.chronos.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chronos.common.dto.UserEvent;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class ProductController {
    private final StreamBridge streamBridge;

    @PostMapping("/activity")
    public ResponseEntity<String> publishActivity(@RequestBody UserEvent event){
        try{
            UserEvent userEvent = new UserEvent(
                    event.eventId(),
                    event.userId(),
                    event.action(),
                    event.pageUrl(),
                    event.ipaddress(),
                    Instant.now().toEpochMilli()
            );

            boolean sent = streamBridge.send("userActivity-out-0", event);
            log.info("Sending event {}, {}, {}, {}" , event.eventId(), event.userId(), event.action(), event.pageUrl());
            if(sent){
                return ResponseEntity.ok("Event streamed successfully");
            }
            else {
                return ResponseEntity.internalServerError().body("Failed to send to stream");
            }
        }
        catch (Exception e){
            log.error("Error publishing event", e);
            return ResponseEntity.internalServerError().body("Error " + e.getMessage());
        }
    }
}
