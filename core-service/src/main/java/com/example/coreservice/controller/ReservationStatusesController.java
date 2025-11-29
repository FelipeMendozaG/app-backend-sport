package com.example.coreservice.controller;

import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.service.ReservationStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("core/api/v1")
public class ReservationStatusesController {
    @Autowired
    public ReservationStatusesService reservationStatusesService;
    @GetMapping("reservation_status")
    public ResponseEntity<List<ReservationStatusesDTO>> getAllReservationStatuses(){
        return new ResponseEntity<>(this.reservationStatusesService.getAll(), HttpStatus.OK);
    }
    @PostMapping("reservation_status")
    public ResponseEntity<ReservationStatusesDTO> saveReservationStatus(@RequestBody ReservationStatusesDTO reservationStatusesDTO){
        return new ResponseEntity<>(this.reservationStatusesService.saveReservationStatuses(reservationStatusesDTO),HttpStatus.CREATED);
    }
    @GetMapping("/reservation_status/{id}")
    public ResponseEntity<ReservationStatusesDTO> getReservationStatus(@PathVariable Integer id){
        return new ResponseEntity<>(this.reservationStatusesService.getReservationStatusesById(id),HttpStatus.OK);
    }
    @PutMapping("reservation_status")
    public ResponseEntity<ReservationStatusesDTO> updateSportType(@RequestBody ReservationStatusesDTO reservationStatusesDTO){
        return new ResponseEntity<>(this.reservationStatusesService.updateReservationStatuses(reservationStatusesDTO),HttpStatus.OK);
    }
    @DeleteMapping("/reservation_status/{id}")
    public ResponseEntity<String> deleteReservationStatus(@PathVariable Integer id){
        return new ResponseEntity<>(this.reservationStatusesService.deleteReservationStatuses(id),HttpStatus.OK);
    }
}
