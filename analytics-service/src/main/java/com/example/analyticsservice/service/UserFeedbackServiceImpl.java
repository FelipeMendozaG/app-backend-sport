package com.example.analyticsservice.service;

import com.example.analyticsservice.model.UserFeedback;
import com.example.analyticsservice.repository.UserFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService{

    @Autowired
    UserFeedbackRepository userFeedbackRepository;

    @Override
    public UserFeedback saveUserFeedback(UserFeedback userFeedback) {
        userFeedback.setTimestamp(new Date());
        return this.userFeedbackRepository.save(userFeedback);
    }

    @Override
    public List<UserFeedback> getAllUserFeedbacks() {
        return this.userFeedbackRepository.findAll();
    }

    @Override
    public Optional<UserFeedback> getUserFeedbackById(String id) {
        return this.userFeedbackRepository.findById(id);
    }
}
