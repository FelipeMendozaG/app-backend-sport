package com.example.coreservice.service;

import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.model.SportType;

import java.util.List;

public interface SportTypeService {
    List<SportTypeDTO> getAll();
    SportTypeDTO getSportTypeById(Integer id);
    SportTypeDTO saveSportType(SportTypeDTO sportTypeDTO);
    SportTypeDTO updateSportType(SportTypeDTO sportTypeDTO);
    String deleteSportType(Integer id);
}
