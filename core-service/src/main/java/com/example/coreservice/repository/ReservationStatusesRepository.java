package com.example.coreservice.repository;

import com.example.coreservice.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusesRepository extends JpaRepository<ReservationStatus, Integer> {
}
