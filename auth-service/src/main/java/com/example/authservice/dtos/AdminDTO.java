package com.example.authservice.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AdminDTO {
    private Long id;

    private UserDTO user;
    private AccessLevel accessLevel;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
