package com.example.authservice.service;

import com.example.authservice.dtos.AdminDTO;
import com.example.authservice.dtos.CreateAdminDTO;

import java.util.List;

public interface AdminService {
    List<AdminDTO> findAll();
    AdminDTO findById(Long id);
    AdminDTO saveAdmin(CreateAdminDTO createAdminDTO);
    String deleteAdmin(Integer id);
}
