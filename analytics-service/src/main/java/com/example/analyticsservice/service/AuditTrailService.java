package com.example.analyticsservice.service;

import com.example.analyticsservice.model.AuditTrail;

import java.util.List;
import java.util.Optional;

public interface AuditTrailService {
    AuditTrail saveAuditTrail(AuditTrail auditTrail);
    List<AuditTrail> getAuditTrails();
    Optional<AuditTrail> getAuditTrailById(String id);
}
