package com.example.analyticsservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Getter
@Setter
@Document(collection = "user_feedback")
public class UserFeedback {
    @Id
    private String id;

    @Field("user_id")
    private Integer userId;

    private String comment;

    private Integer rating;

    private Date timestamp;

    public UserFeedback() {}

    public UserFeedback(Integer userId, String comment, Integer rating, Date timestamp) {
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.timestamp = timestamp;
    }
}
