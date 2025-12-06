package com.example.analyticsservice.service;

import com.example.analyticsservice.model.AuditTrail;
import com.example.analyticsservice.repository.AuditTrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class AuditTrailServiceImpl implements AuditTrailService{
    @Autowired
    private AuditTrailRepository auditTrailRepository;
    @Override
    public AuditTrail saveAuditTrail(AuditTrail auditTrail) {
        auditTrail.setTimestamp(new Date());
        return this.auditTrailRepository.save(auditTrail);
    }

    @Override
    public List<AuditTrail> getAuditTrails() {
        return this.auditTrailRepository.findAll();
    }

    @Override
    public Optional<AuditTrail> getAuditTrailById(String id) {
        return this.auditTrailRepository.findById(id);
    }
}
