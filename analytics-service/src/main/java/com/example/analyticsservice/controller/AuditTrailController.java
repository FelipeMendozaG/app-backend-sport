package com.example.analyticsservice.controller;

import com.example.analyticsservice.model.AuditTrail;
import com.example.analyticsservice.service.AuditTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analytics/api/v1")
public class AuditTrailController {
    @Autowired
    private AuditTrailService auditTrailService;
    @PostMapping("audit-trails")
    public ResponseEntity<AuditTrail> createAuditTrail(@RequestBody AuditTrail auditTrail){
        AuditTrail a =this.auditTrailService.saveAuditTrail(auditTrail);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }
    @GetMapping("audit-trails")
    public ResponseEntity<List<AuditTrail>> getAuditTrails(){
        List<AuditTrail> auditTrails = this.auditTrailService.getAuditTrails();
        return new ResponseEntity<>(auditTrails, HttpStatus.OK);
    }
}
