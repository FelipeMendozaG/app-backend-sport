package com.example.authservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String token;
    // private UserDTO user;
    private String message;
    private boolean success;
    public LoginResponseDTO(UserDTO user, String message, boolean success) {
        // this.user = user;
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.message = message;
        this.success = success;
    }

    public LoginResponseDTO(String token, UserDTO user, String message, boolean success) {
        this.token = token;
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        // this.user = user;
        this.message = message;
        this.success = success;
    }
}
