package com.example.authservice.service;

import com.example.authservice.dtos.AdminDTO;
import com.example.authservice.dtos.CreateAdminDTO;
import com.example.authservice.mappers.AdminMapper;
import com.example.authservice.mappers.UserMapper;
import com.example.authservice.model.Admin;
import com.example.authservice.model.User;
import com.example.authservice.repository.AdminRepository;
import com.example.authservice.repository.UserRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    public AdminServiceImpl(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<AdminDTO> findAll() {
        return AdminMapper.INSTANCE.adminsToAdminsDTOs(this.adminRepository.findAll());
    }

    @Override
    public AdminDTO findById(Long id) {
        return null;
    }

    @Override
    public AdminDTO saveAdmin(CreateAdminDTO createdAdminDTO) {
        User user = this.userRepository.findById(createdAdminDTO.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        System.out.println(this.adminRepository.existsByUserId(user.getId()));
        if(this.adminRepository.existsByUserId(user.getId())){
            throw new RuntimeException("User already exists");
        }
        Admin admin = new Admin();
        admin.setUser(user);
        admin.setAccessLevel(createdAdminDTO.getAccessLevel());
        Admin saveAdmin = this.adminRepository.save(admin);
        return AdminMapper.INSTANCE.adminToAdminDTO(saveAdmin);
    }

    @Override
    public String deleteAdmin(Integer id) {
        Optional <Admin> admin = this.adminRepository.findById(id);
        if(admin.isPresent()){
            this.adminRepository.deleteById(id);
            return "Admin deleted";
        }else{
            throw new RuntimeException("Admin not found");
        }

    }

}