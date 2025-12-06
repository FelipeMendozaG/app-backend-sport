package com.example.analyticsservice.service;

import com.example.analyticsservice.model.UserFeedback;

import java.util.List;
import java.util.Optional;

public interface UserFeedbackService {
    UserFeedback saveUserFeedback(UserFeedback userFeedback);
    List<UserFeedback> getAllUserFeedbacks();
    Optional<UserFeedback> getUserFeedbackById(String id);
}
