package com.example.authservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
