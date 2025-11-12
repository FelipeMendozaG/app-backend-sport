package com.example.authservice.service;

import com.example.authservice.dtos.*;

import java.util.List;

public interface UserService {
    List<UserDTO> listUsers();
    UserDTO getUserById(int id);
    UserDTO getUserByEmail(String email);
    UserDTO saveUser(UserCreateDTO userCreateDTO);
    UserDTO updateUser(UserUpdateDTO userUpdateDTO);
    String deleteUser(int id);
    LoginResponseDTO login(LoginDTO loginRequestDTO);
}
