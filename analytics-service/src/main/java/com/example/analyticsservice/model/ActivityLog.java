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
@Document(collection = "activity_logs")
public class ActivityLog {
    @Id
    private String id;

    @Field("user_id")
    private Integer userId;

    private String action;

    @Field("reservation_id")
    private Integer reservationId;

    private Date timestamp;

    private Map<String, Object> details;

    public ActivityLog() {}

    public ActivityLog(Integer userId, String action, Integer reservationId, Date timestamp, Map<String, Object> details) {
        this.userId = userId;
        this.action = action;
        this.reservationId = reservationId;
        this.timestamp = timestamp;
        this.details = details;
    }
}
