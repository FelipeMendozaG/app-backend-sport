package com.example.authservice.controller;

import com.example.authservice.dtos.AdminDTO;
import com.example.authservice.dtos.CreateAdminDTO;
import com.example.authservice.service.AdminService;
import com.example.authservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("auth/api/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @PostMapping("admins")
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody CreateAdminDTO createdAdminDTO) {
        System.out.println(createdAdminDTO);
        return new ResponseEntity<>(this.adminService.saveAdmin(createdAdminDTO), HttpStatus.CREATED);
    }

    @GetMapping("admins")
    public ResponseEntity<List<AdminDTO>> findAllAdmins(){
        return new ResponseEntity<>(this.adminService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<String>  deleteAdmin(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.adminService.deleteAdmin(id),HttpStatus.OK);
    }

}
