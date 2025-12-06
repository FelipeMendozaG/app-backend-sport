package com.example.analyticsservice.controller;

import com.example.analyticsservice.model.SystemEvent;
import com.example.analyticsservice.service.SystemEventService;
import com.example.analyticsservice.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analytics/api/v1")
public class SystemEventController {
    @Autowired
    private SystemEventService systemEventService;

    @PostMapping("system-events")
    public ResponseEntity<SystemEvent> saveSystemEvents(@RequestBody SystemEvent systemEvent) {
        SystemEvent se = this.systemEventService.saveSystemEvent(systemEvent);
        return new ResponseEntity<>(se, HttpStatus.CREATED);
    }
    @GetMapping("system-events")
    public ResponseEntity<List<SystemEvent>> getAllSystemEvents() {
        List<SystemEvent> eve = this.systemEventService.getSystemEvents();
        return new ResponseEntity<>(eve, HttpStatus.OK);
    }
}
