package com.example.coreservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class FieldResponseDTO {
    private Integer id;
    private String name;
    private SportTypeDTO sportType;
    private Boolean isActive;
    private BigDecimal price;
    private String urlImage;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
