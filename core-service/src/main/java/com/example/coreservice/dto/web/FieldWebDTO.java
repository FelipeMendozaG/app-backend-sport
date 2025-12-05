package com.example.coreservice.dto.web;

import com.example.coreservice.dto.ScheduleDTO;
import com.example.coreservice.model.Schedule;
import com.example.coreservice.model.SportType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FieldWebDTO {
    private Integer id;
    private String name;
    private SportType sportType;
    private Boolean isActive;
    private BigDecimal price;
    private String urlImage;
    private String description;
    private List<ScheduleDTO> schedules;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
