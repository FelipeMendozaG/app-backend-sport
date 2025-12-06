package com.example.coreservice.service;

import com.example.coreservice.dto.FieldCreateDTO;
import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.dto.FieldResponseDTO;
import com.example.coreservice.dto.ReservationCreateDTO;
import com.example.coreservice.dto.web.FieldWebDTO;
import com.example.coreservice.dto.web.ReservationValidWebDTO;
import com.example.coreservice.mappers.FieldMapper;
import com.example.coreservice.mappers.ReservationStatusesMapper;
import com.example.coreservice.model.*;
import com.example.coreservice.repository.*;
import com.example.coreservice.service.storage.GoogleStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class FieldServiceImpl implements FieldService {
    private static final Logger log = LoggerFactory.getLogger(FieldServiceImpl.class);
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;
    private final SportTypeRepository sportTypeRepository;
    private final GoogleStorageService googleStorageService;
    private final ScheduleRepository scheduleRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationStatusesRepository reservationStatusesRepository;
    public FieldServiceImpl(FieldMapper fieldMapper, FieldRepository fieldRepository, SportTypeRepository sportTypeRepository, GoogleStorageService googleStorageService, ScheduleRepository scheduleRepository, ReservationStatusesRepository reservationStatusesRepository, ReservationRepository reservationRepository) {
        this.fieldRepository = fieldRepository;
        this.fieldMapper = fieldMapper;
        this.sportTypeRepository = sportTypeRepository;
        this.googleStorageService = googleStorageService;
        this.scheduleRepository = scheduleRepository;
        this.reservationStatusesRepository = reservationStatusesRepository;
        this.reservationRepository = reservationRepository;
    }
    @Override
    public List<FieldDTO> getAll() {
        List<Field> fields = fieldRepository.findAllWithSportType();
        return this.fieldMapper.fieldsToFieldDTOs(fields);
    }

    @Override
    public FieldDTO getById(Integer id) {
        Field field = fieldRepository.findById(id).orElse(null);
        if(field == null){
            throw new IllegalArgumentException("Field not found");
        }
        return this.fieldMapper.fieldToFieldDTO(field);
    }

    @Override
    public FieldDTO getByName(String name) {
        return null;
    }

    @Override
    public FieldResponseDTO saveField(FieldCreateDTO fieldCreateDTO) throws IOException {
        SportType sportType = this.sportTypeRepository.findById(fieldCreateDTO.getSportTypeId()).orElseThrow(() -> new RuntimeException("SportType not found"));
        String imageUrl = null;
        if(fieldCreateDTO.getImageFile() != null && !fieldCreateDTO.getImageFile().isEmpty()){
            imageUrl = this.googleStorageService.uploadFile(fieldCreateDTO.getImageFile(),"fields");
        }
        Field field = new Field();
        field.setName(fieldCreateDTO.getName());
        field.setSportType(sportType);
        field.setIsActive(fieldCreateDTO.getIsActive());
        field.setPrice(fieldCreateDTO.getPrice());
        field.setUrlImage(imageUrl);
        field.setDescription(fieldCreateDTO.getDescription());
        Field savedField = fieldRepository.save(field);
        return this.fieldMapper.fieldToFieldResponseDTO(savedField);
    }

    @Override
    public FieldDTO updateField(FieldDTO fieldDTO) {
        return null;
    }

    @Override
    public String deleteField(Integer id) {
        Optional<Field> field = this.fieldRepository.findById(id);
        if(field.isPresent()){
            this.fieldRepository.delete(field.get());
            return "Registro eliminado";
        }
        throw new IllegalArgumentException("Field not found");
    }

    @Override
    public List<FieldWebDTO> getWebAll(){
        List<Field> fields = fieldRepository.findAllActiveWithSportType();
        return this.fieldMapper.fieldsToFieldWebDTOs(fields);
    }
    @Override
    public FieldWebDTO getWebById(Integer id) {
        Field field = this.fieldRepository.findByIdWithSportTypeAndSchedules(id).orElseThrow(()->new RuntimeException("Field no encontrado"));
        return this.fieldMapper.fieldToFieldWebDTO(field);
    }

    @Override
    public List<ReservationValidWebDTO> getReservationValidWebDTOById(Long id, String day_of_week){
        return this.fieldRepository.findFieldScheduleReservations(day_of_week, id);
    }

    @Override
    public ReservationCreateDTO saveReservation(ReservationCreateDTO reservationCreateDTO) {
        Reservation reservation = new Reservation();
        Field f =this.fieldRepository.findById(reservationCreateDTO.getFieldId()).orElseThrow(()->new RuntimeException("Field not found"));
        Schedule s = this.scheduleRepository.findById(reservationCreateDTO.getScheduleId()).orElseThrow(()->new RuntimeException("Schedule not found"));
        ReservationStatus rs = this.reservationStatusesRepository.findById(1).orElseThrow(()->new RuntimeException("ReservationStatus not found"));
        reservation.setField(f);
        reservation.setUserId(reservationCreateDTO.getUserId());
        reservation.setSchedule(s);
        reservation.setReservationDate(LocalDate.now());
        reservation.setStatus(rs);
        this.reservationRepository.save(reservation);
        return reservationCreateDTO;
    }

}
