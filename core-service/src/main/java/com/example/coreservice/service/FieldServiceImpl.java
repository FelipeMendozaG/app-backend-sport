package com.example.coreservice.service;

import com.example.coreservice.dto.FieldDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FieldServiceImpl implements FieldService {
    @Override
    public List<FieldDTO> getAll() {
        return List.of();
    }

    @Override
    public FieldDTO getById(String id) {
        return null;
    }

    @Override
    public FieldDTO getByName(String name) {
        return null;
    }

    @Override
    public FieldDTO saveField(FieldDTO fieldDTO) {
        return null;
    }

    @Override
    public FieldDTO updateField(FieldDTO fieldDTO) {
        return null;
    }

    @Override
    public String deleteField(String id) {
        return "";
    }
}
