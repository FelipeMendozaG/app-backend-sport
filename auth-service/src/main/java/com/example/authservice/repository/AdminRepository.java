package com.example.authservice.repository;

import com.example.authservice.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    boolean existsByUserId(Long userId);
    Admin findByUserId(Long userId);
}
