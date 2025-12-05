package com.example.coreservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationCreateDTO {
    private Integer Id;
    private Integer fieldId;
    private Integer scheduleId;
    private Integer statusId;
    private LocalDate reservationDate;
}
