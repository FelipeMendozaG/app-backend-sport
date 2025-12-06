package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.SystemEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SystemEventRepository extends MongoRepository<SystemEvent, String> {
    List<SystemEvent> findByEventType(String eventType);
    List<SystemEvent> findByService(String service);
    List<SystemEvent> findByEventTypeAndService(String eventType, String service);
}
