package com.example.coreservice.mappers;

import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.dto.FieldResponseDTO;
import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.model.Field;
import com.example.coreservice.model.SportType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FieldMapper {
    FieldResponseDTO fieldToFieldResponseDTO(Field field);
    FieldDTO fieldToFieldDTO(Field field);
    Field fieldDTOToField(FieldDTO fieldDTO);
    List<FieldDTO> fieldsToFieldDTOs(List<Field> fields);
    default SportTypeDTO map(SportType sportType) {
        if (sportType == null) {
            return null;
        }

        SportTypeDTO dto = new SportTypeDTO();
        dto.setId(sportType.getId());
        dto.setName(sportType.getName());
        return dto;
    }
}
