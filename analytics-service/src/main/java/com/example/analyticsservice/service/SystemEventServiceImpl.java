package com.example.analyticsservice.service;

import com.example.analyticsservice.model.SystemEvent;
import com.example.analyticsservice.repository.SystemEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class SystemEventServiceImpl implements SystemEventService {
    @Autowired
    SystemEventRepository systemEventRepository;
    @Override
    public SystemEvent saveSystemEvent(SystemEvent systemEvent) {
        systemEvent.setTimestamp(new Date());
        return this.systemEventRepository.save(systemEvent);
    }

    @Override
    public List<SystemEvent> getSystemEvents() {
        return this.systemEventRepository.findAll();
    }

    @Override
    public Optional<SystemEvent> getSystemEventById(String id) {
        return this.systemEventRepository.findById(id);
    }
}
