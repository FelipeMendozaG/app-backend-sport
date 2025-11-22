package com.example.authservice.repository;

import com.example.authservice.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    boolean existsByUserId(Long userId);
}
