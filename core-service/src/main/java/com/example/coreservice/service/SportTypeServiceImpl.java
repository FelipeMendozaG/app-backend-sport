package com.example.coreservice.service;

import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.mappers.SportTypeMapper;
import com.example.coreservice.model.SportType;
import com.example.coreservice.repository.SportTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportTypeServiceImpl implements SportTypeService {
    private final SportTypeRepository sportTypeRepository;
    private final SportTypeMapper sportTypeMapper;
    public SportTypeServiceImpl(SportTypeRepository sportTypeRepository, SportTypeMapper sportTypeMapper) {
        this.sportTypeRepository = sportTypeRepository;
        this.sportTypeMapper = sportTypeMapper;
    }
    @Override
    public List<SportTypeDTO> getAll() {
        List<SportType> sportTypes = sportTypeRepository.findAll();
        return this.sportTypeMapper.sportTypeToSportTypeDTOs(sportTypes);
    }

    @Override
    public SportTypeDTO getSportTypeById(Integer id) {
        SportType sportType = sportTypeRepository.findById(id).orElse(null);
        return this.sportTypeMapper.sportTypeToSportTypeDTO(sportType);
    }

    @Override
    public SportTypeDTO saveSportType(SportTypeDTO sportTypeDTO) {
        SportType sportType = this.sportTypeMapper.sportTypeDTOToSportType(sportTypeDTO);
        SportType sportTypeResponse =this.sportTypeRepository.save(sportType);
        return this.sportTypeMapper.sportTypeToSportTypeDTO(sportTypeResponse);
    }

    @Override
    public SportTypeDTO updateSportType(SportTypeDTO sportTypeDTO) {
        if(sportTypeDTO.getId()==null){
            throw new IllegalArgumentException("Sport Type ID cannot be null");
        }
        SportType sportType = this.sportTypeRepository.findById(sportTypeDTO.getId()).orElseThrow(()-> new RuntimeException("Sport Type ID not found"));
        sportType.setName(sportTypeDTO.getName());
        SportType updatedSportType = this.sportTypeRepository.save(sportType);
        return this.sportTypeMapper.sportTypeToSportTypeDTO(updatedSportType);
    }

    @Override
    public String deleteSportType(Integer id) {
        Optional<SportType> sportType = this.sportTypeRepository.findById(id);
        if (sportType.isPresent()) {
            this.sportTypeRepository.delete(sportType.get());
            return "Registro eliminado";
        }
        return "No se pudo elminar el registro";
    }
}
