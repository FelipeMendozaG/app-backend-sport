package com.example.coreservice.service;

import com.example.coreservice.dto.ReservationStatusesDTO;

import java.util.List;

public interface ReservationStatusesService {
    List<ReservationStatusesDTO> getAll();
    ReservationStatusesDTO getReservationStatusesById(Integer id);
    ReservationStatusesDTO saveReservationStatuses(ReservationStatusesDTO rs);
    ReservationStatusesDTO updateReservationStatuses(ReservationStatusesDTO rs);
    String deleteReservationStatuses(Integer id);

}
