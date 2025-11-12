package com.example.authservice.controller;

import com.example.authservice.dtos.*;
import com.example.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(this.userService.listUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponseDTO> userLogin(@RequestBody LoginDTO loginRequestDTO) {
        LoginResponseDTO response = userService.login(loginRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return new ResponseEntity<>(this.userService.saveUser(userCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        return new ResponseEntity<>(this.userService.updateUser(userUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.OK);
    }

}
