package com.example.coreservice.service;

import com.example.coreservice.dto.FieldCreateDTO;
import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.dto.FieldResponseDTO;
import com.example.coreservice.dto.web.FieldWebDTO;

import java.io.IOException;
import java.util.List;

public interface FieldService {
    List<FieldDTO> getAll();
    FieldDTO getById(Integer id);
    FieldDTO getByName(String name);
    FieldResponseDTO saveField(FieldCreateDTO fieldCreateDTO) throws IOException;
    FieldDTO updateField(FieldDTO fieldDTO);
    String deleteField(Integer id);
    // FUNCIONES PARA LA WEB
    List<FieldWebDTO> getWebAll();
    FieldWebDTO getWebById(Integer id);
}
