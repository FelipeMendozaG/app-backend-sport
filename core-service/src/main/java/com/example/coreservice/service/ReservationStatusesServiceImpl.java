package com.example.coreservice.service;

import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.mappers.ReservationStatusesMapper;
import com.example.coreservice.repository.ReservationStatusesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return List.of();
    }

    @Override
    public ReservationStatusesDTO getReservationStatusesById(Integer id) {
        return null;
    }

    @Override
    public ReservationStatusesDTO saveReservationStatuses(ReservationStatusesDTO rs) {
        return null;
    }

    @Override
    public ReservationStatusesDTO updateReservationStatuses(ReservationStatusesDTO rs) {
        return null;
    }

    @Override
    public String deleteReservationStatuses(Integer id) {
        return "";
    }
}
