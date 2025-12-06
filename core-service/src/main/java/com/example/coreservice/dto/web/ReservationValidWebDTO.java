package com.example.coreservice.dto.web;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
@Getter
@Setter
public class ReservationValidWebDTO {
    private Integer ScheduleId;
    private Integer id;
    private BigDecimal price;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private Boolean isAvailable;
    private Long reservationId;
    public ReservationValidWebDTO(
            Integer ScheduleId,
            Integer id,
            BigDecimal price,
            String dayOfWeek,
            String startTime,
            String endTime,
            Boolean isAvailable,
            Long reservationId
    ) {
        this.ScheduleId = ScheduleId;
        this.id = id;
        this.price = price;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = isAvailable;
        this.reservationId = reservationId;
    }
    public ReservationValidWebDTO() {}
}
