package com.example.coreservice.dto;

import com.example.coreservice.model.SportType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FieldDTO {
    private Integer id;
    private String name;
    private SportType sportType;
    private Boolean isActive;
    private BigDecimal price;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
