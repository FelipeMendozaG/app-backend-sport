package com.example.coreservice.dto.web;

import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.model.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationWebDTO {
    private Integer id;
    private Integer UserId;
    private FieldDTO field;
    private Schedule schedule;
    private ReservationStatusesDTO reservationStatusesDTO;
    private LocalDate reservationDate;
}
