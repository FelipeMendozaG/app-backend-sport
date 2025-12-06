package com.example.analyticsservice.service;

import com.example.analyticsservice.model.SystemEvent;

import java.util.List;
import java.util.Optional;

public interface SystemEventService {
    SystemEvent saveSystemEvent(SystemEvent systemEvent);
    List<SystemEvent> getSystemEvents();
    Optional<SystemEvent> getSystemEventById(String id);
}
