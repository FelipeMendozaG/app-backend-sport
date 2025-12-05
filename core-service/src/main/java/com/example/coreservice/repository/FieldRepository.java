package com.example.coreservice.repository;

import com.example.coreservice.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldRepository extends JpaRepository<Field,Integer> {
    List<Field> findByIsActiveTrue();
    List<Field> findByIsActiveFalse();
    @Query("SELECT f FROM Field f LEFT JOIN FETCH f.sportType")
    List<Field> findAllWithSportType();

    @Query("SELECT f FROM Field f LEFT JOIN FETCH f.sportType WHERE f.isActive = true")
    List<Field> findAllActiveWithSportType();

    @Query("SELECT f FROM Field f LEFT JOIN FETCH f.sportType WHERE f.id = :id")
    Optional<Field> findByIdWithSportType(@Param("id") Integer id);

    @Query("SELECT f FROM Field f " +
            "LEFT JOIN FETCH f.sportType " +
            "LEFT JOIN FETCH f.schedules s " +
            "WHERE f.id = :id")
    Optional<Field> findByIdWithSportTypeAndSchedules(@Param("id") Integer id);
}
