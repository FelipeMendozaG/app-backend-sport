package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.AuditTrail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuditTrailRepository extends MongoRepository<AuditTrail,String> {
    List<AuditTrail> findByUserId(Integer userId);
    List<AuditTrail> findByEntity(String entity);
    List<AuditTrail> findByEntityAndEntityId(String entity, Integer entityId);
    List<AuditTrail> findByAction(String action);
}
