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
@Document(collection = "audit_trails")
public class AuditTrail {
    @Id
    private String id;

    @Field("user_id")
    private Integer userId;

    private String entity;

    @Field("entity_id")
    private Integer entityId;

    private String action;

    private Date timestamp;

    private Map<String, Object> metadata;

    // Constructors
    public AuditTrail() {}

    public AuditTrail(Integer userId, String entity, Integer entityId, String action, Date timestamp, Map<String, Object> metadata) {
        this.userId = userId;
        this.entity = entity;
        this.entityId = entityId;
        this.action = action;
        this.timestamp = timestamp;
        this.metadata = metadata;
    }
}
