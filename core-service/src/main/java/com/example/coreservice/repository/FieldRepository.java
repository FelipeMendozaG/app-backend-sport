package com.example.coreservice.repository;

import com.example.coreservice.dto.web.ReservationValidWebDTO;
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

    @Query(value = """
        SELECT 
            s.id as scheduleId,
            f.id as id,
            f.price as price,
            s.day_of_week as dayOfWeek, 
            TIME_FORMAT(s.start_time, '%H:%i:%s') as startTime, 
            TIME_FORMAT(s.end_time, '%H:%i:%s') as endTime, 
            s.is_available as isAvailable,
            r.id as reservationId
        FROM fields f 
        INNER JOIN schedules s ON s.field_id = f.id 
        LEFT JOIN reservations r ON r.field_id = f.id and r.schedule_id = s.id
        WHERE s.day_of_week = :dayOfWeek
        AND f.id = :fieldId
        """, nativeQuery = true)
    List<ReservationValidWebDTO> findFieldScheduleReservations(@Param("dayOfWeek") String dayOfWeek, @Param("fieldId") Long fieldId);
}
