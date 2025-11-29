package com.example.coreservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
public class FieldCreateDTO {
    private String name;
    private Integer sportTypeId;
    private Boolean isActive = true;
    private BigDecimal price = BigDecimal.ZERO;
    private String description;
    private MultipartFile imageFile;
}
