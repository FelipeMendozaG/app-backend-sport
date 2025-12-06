package com.example.analyticsservice.service;

import com.example.analyticsservice.model.ActivityLog;
import com.example.analyticsservice.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ActivityLogServiceImpl implements ActivityLogService{
    @Autowired
    private ActivityLogRepository activityLogRepository;
    @Override
    public ActivityLog createActivityLog(ActivityLog activityLog) {
        activityLog.setTimestamp(new Date());
        return this.activityLogRepository.save(activityLog);
    }

    @Override
    public List<ActivityLog> getAllActivityLogs() {
        return this.activityLogRepository.findAll();
    }

    @Override
    public Optional<ActivityLog> getActivityLogById(String id) {
        return this.activityLogRepository.findById(id);
    }

    @Override
    public List<ActivityLog> getActivityLogsByUsersId(Integer id) {
        return this.activityLogRepository.findByUserId(id);
    }
}
