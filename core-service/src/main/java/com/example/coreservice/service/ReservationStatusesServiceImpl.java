package com.example.coreservice.service;

import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.mappers.ReservationStatusesMapper;
import com.example.coreservice.model.ReservationStatus;
import com.example.coreservice.repository.ReservationStatusesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationStatusesServiceImpl implements  ReservationStatusesService {
    private final ReservationStatusesRepository reservationStatusesRepository;
    private final ReservationStatusesMapper reservationStatusesMapper;
    public ReservationStatusesServiceImpl(ReservationStatusesRepository reservationStatusesRepository,ReservationStatusesMapper  reservationStatusesMapper) {
        this.reservationStatusesMapper = reservationStatusesMapper;
        this.reservationStatusesRepository = reservationStatusesRepository;
    }
    @Override
    public List<ReservationStatusesDTO> getAll() {
        List<ReservationStatus> reservationStatuses = this.reservationStatusesRepository.findAll();
        return this.reservationStatusesMapper.reservationStatusToReservationStatusDTOs(reservationStatuses);
    }

    @Override
    public ReservationStatusesDTO getReservationStatusesById(Integer id) {
        ReservationStatus reservationStatus = this.reservationStatusesRepository.findById(id).orElse(null);
        if(reservationStatus==null){
            throw new IllegalArgumentException("reservationStatus not found");
        }
        return this.reservationStatusesMapper.reservationStatusToReservationStatusDTO(reservationStatus);
    }

    @Override
    public ReservationStatusesDTO saveReservationStatuses(ReservationStatusesDTO rs) {
        ReservationStatus reservationStatus = this.reservationStatusesMapper.reservationStatusDTOToReservationStatus(rs);
        ReservationStatus reservationStatusCreate = this.reservationStatusesRepository.save(reservationStatus);
        return this.reservationStatusesMapper.reservationStatusToReservationStatusDTO(reservationStatusCreate);
    }

    @Override
    public ReservationStatusesDTO updateReservationStatuses(ReservationStatusesDTO rs) {
        if(rs.getId()==null){
            throw new IllegalArgumentException("Id invalido");
        }
        ReservationStatus reservationStatus = this.reservationStatusesRepository.findById(rs.getId()).orElse(null);
        reservationStatus.setName(rs.getName());
        ReservationStatus reservationStatusUpdate = this.reservationStatusesRepository.save(reservationStatus);
        return this.reservationStatusesMapper.reservationStatusToReservationStatusDTO(reservationStatusUpdate);
    }

    @Override
    public String deleteReservationStatuses(Integer id) {
        Optional<ReservationStatus> reservationStatus = this.reservationStatusesRepository.findById(id);
        if(reservationStatus.isPresent()){
            this.reservationStatusesRepository.delete(reservationStatus.get());
            return "Registro eliminado";
        }
        return "No se pudo eliminar el registro mencionado";
    }
}
