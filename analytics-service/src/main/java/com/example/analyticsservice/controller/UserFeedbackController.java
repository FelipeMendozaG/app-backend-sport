package com.example.analyticsservice.controller;

import com.example.analyticsservice.model.UserFeedback;
import com.example.analyticsservice.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analytics/api/v1")
public class UserFeedbackController {
    @Autowired
    private UserFeedbackService userFeedbackService;

    @PostMapping("user-feedbacks")
    private ResponseEntity<UserFeedback> createUserFeedback(@RequestBody UserFeedback userFeedback) {
        UserFeedback userf = this.userFeedbackService.saveUserFeedback(userFeedback);
        return new ResponseEntity<>(userf, HttpStatus.OK);
    }
    @GetMapping("user-feedbacks")
    private ResponseEntity<List<UserFeedback>> getAllUserFeedbacks() {
        return ResponseEntity.ok(this.userFeedbackService.getAllUserFeedbacks());
    }
}
