package com.example.coreservice.controller;

import com.example.coreservice.dto.ReservationCreateDTO;
import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.dto.web.FieldWebDTO;
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
    @GetMapping("web/reservation")
    public ResponseEntity<List<ReservationWebDTO>> getReservationStatuses() {
        return null;
    }
    @PostMapping("web/reservation")
    public ResponseEntity<ReservationWebDTO> saveReservation(@RequestBody ReservationCreateDTO reservationCreateDTO) {
        return new ResponseEntity<>(new ReservationWebDTO(), HttpStatus.OK);
    }

}
