package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityLogRepository extends MongoRepository<ActivityLog, String> {
    List<ActivityLog> findByUserId(Integer userId);
    List<ActivityLog> findByAction(String action);
    List<ActivityLog> findByReservationId(Integer reservationId);
}
