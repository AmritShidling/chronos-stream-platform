package com.chronos.common.dto;

import java.time.Instant;

public record UserEvent(String eventId, String userId, String action, String pageUrl, String ipaddress, long timestamp) {
}