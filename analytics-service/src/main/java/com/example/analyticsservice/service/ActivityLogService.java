package com.example.analyticsservice.service;

import com.example.analyticsservice.model.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    ActivityLog createActivityLog(ActivityLog activityLog);
    List<ActivityLog> getAllActivityLogs();
    Optional<ActivityLog> getActivityLogById(String id);
    List<ActivityLog> getActivityLogsByUsersId(Integer id);
}
