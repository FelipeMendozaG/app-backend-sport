package com.example.analyticsservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@Document(collection = "system_events")
public class SystemEvent {
    @Id
    private String id;

    @Field("event_type")
    private String eventType;

    private String service;

    private Date timestamp;

    private String message;

    private Map<String, Object> metadata;

    // Constructors
    public SystemEvent() {}

    public SystemEvent(String eventType, String service, Date timestamp, String message, Map<String, Object> metadata) {
        this.eventType = eventType;
        this.service = service;
        this.timestamp = timestamp;
        this.message = message;
        this.metadata = metadata;
    }
}
