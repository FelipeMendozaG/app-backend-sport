package com.example.analyticsservice.repository;

import com.example.analyticsservice.model.UserFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserFeedbackRepository extends MongoRepository<UserFeedback, String> {
    List<UserFeedback> findByUserId(Integer userId);
    List<UserFeedback> findByRating(Integer rating);
    List<UserFeedback> findByRatingGreaterThanEqual(Integer minRating);
}
