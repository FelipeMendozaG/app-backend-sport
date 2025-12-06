package com.example.coreservice.controller;

import com.example.coreservice.dto.ReservationCreateDTO;
import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.dto.web.FieldWebDTO;
import com.example.coreservice.dto.web.ReservationValidWebDTO;
import com.example.coreservice.dto.web.ReservationWebDTO;
import com.example.coreservice.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("core/api/v1")
public class WebController {
    @Autowired
    private FieldService fieldService;

    @GetMapping("web/fields")
    public ResponseEntity<List<FieldWebDTO>> getFields() {
        return new ResponseEntity<>(this.fieldService.getWebAll(),HttpStatus.OK);
    }
    @GetMapping("web/fields/{id}")
    public ResponseEntity<FieldWebDTO> getField(@PathVariable Integer id) {
        return new ResponseEntity<>(this.fieldService.getWebById(id), HttpStatus.OK);
    }
    @GetMapping("web/list_reservations/{id}/{day_of_week}")
    public ResponseEntity<List<ReservationValidWebDTO>> getReservations(@PathVariable Long id, @PathVariable String day_of_week) {
        //this.fieldService.debugFieldQuery(day_of_week, id);
        //return new ResponseEntity<>(null, HttpStatus.OK);
        return new ResponseEntity<>(this.fieldService.getReservationValidWebDTOById(id,day_of_week), HttpStatus.OK);
    }
    @GetMapping("web/reservation")
    public ResponseEntity<List<ReservationWebDTO>> getReservationStatuses() {
        return null;
    }
    @PostMapping("web/reservation")
    public ResponseEntity<ReservationCreateDTO> saveReservation(@RequestBody ReservationCreateDTO reservationCreateDTO) {
        return new ResponseEntity<>(this.fieldService.saveReservation(reservationCreateDTO), HttpStatus.OK);
    }

}
