package com.example.coreservice.repository;

import com.example.coreservice.model.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportTypeRepository extends JpaRepository<SportType,Integer> {
}
