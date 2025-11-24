package com.example.coreservice.mappers;

import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.model.SportType;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface SportTypeMapper {
    // SportTypeMapper INSTANCE = Mappers.getMapper(SportTypeMapper.class);
    SportTypeDTO sportTypeToSportTypeDTO(SportType sportType);
    SportType sportTypeDTOToSportType(SportTypeDTO sportTypeDTO);
    SportType sportTypeCreateDTOToSportType(SportTypeDTO sportTypeDTO);
    List<SportTypeDTO> sportTypeToSportTypeDTOs(List<SportType> sportTypes);
}
