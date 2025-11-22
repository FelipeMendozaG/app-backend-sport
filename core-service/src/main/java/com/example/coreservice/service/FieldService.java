package com.example.coreservice.service;

import com.example.coreservice.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    List<FieldDTO> getAll();
    FieldDTO getById(String id);
    FieldDTO getByName(String name);
    FieldDTO saveField(FieldDTO fieldDTO);
    FieldDTO updateField(FieldDTO fieldDTO);
    String deleteField(String id);
}
