package com.example.coreservice.mappers;

import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.dto.FieldResponseDTO;
import com.example.coreservice.dto.ScheduleDTO;
import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.dto.web.FieldWebDTO;
import com.example.coreservice.model.Field;
import com.example.coreservice.model.Schedule;
import com.example.coreservice.model.SportType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    FieldDTO fieldToFieldDTO(Field field);
    Field fieldDTOToField(FieldDTO fieldDTO);
    List<FieldDTO> fieldsToFieldDTOs(List<Field> fields);
    FieldResponseDTO fieldToFieldResponseDTO(Field field);
    default SportTypeDTO map(SportType sportType) {
        if (sportType == null) {
            return null;
        }

        SportTypeDTO dto = new SportTypeDTO();
        dto.setId(sportType.getId());
        dto.setName(sportType.getName());
        return dto;
    }
    List<FieldWebDTO> fieldsToFieldWebDTOs(List<Field> fields);
    @Mapping(source = "schedules", target = "schedules")
    FieldWebDTO fieldToFieldWebDTO(Field field);
    ScheduleDTO scheduleToScheduleDTO(Schedule schedule);
}
