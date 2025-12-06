package com.example.analyticsservice.controller;

import com.example.analyticsservice.model.ActivityLog;
import com.example.analyticsservice.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("analytics/api/v1")
public class ActivityLogController {
    @Autowired
    private ActivityLogService activityLogService;

    @PostMapping("activity-logs")
    public ResponseEntity<ActivityLog> createActivityLog(@RequestBody ActivityLog activityLog) {
        ActivityLog createdLog = this.activityLogService.createActivityLog(activityLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLog);
    }

    @GetMapping("activity-logs")
    public ResponseEntity<List<ActivityLog>> getAllActivityLogs(){
        List<ActivityLog> logs = this.activityLogService.getAllActivityLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @GetMapping("activity-logs/{id}")
    public ResponseEntity<ActivityLog> getActivityLogById(@PathVariable("id") String id) {
        Optional<ActivityLog> log = this.activityLogService.getActivityLogById(id);
        return new ResponseEntity<>(log.get(), HttpStatus.OK);
    }

}
