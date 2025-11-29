package com.example.coreservice.mappers;

import com.example.coreservice.dto.ReservationStatusesDTO;
import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.model.ReservationStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationStatusesMapper {
    ReservationStatusesDTO reservationStatusToReservationStatusDTO(ReservationStatus reservationStatus);
    ReservationStatus reservationStatusDTOToReservationStatus(ReservationStatusesDTO reservationStatusDTO);
    ReservationStatus reservationStatusCreateDTOToReservationStatus(ReservationStatusesDTO reservationStatusDTO);
    List<ReservationStatusesDTO> reservationStatusToReservationStatusDTOs(List<ReservationStatus> reservationStatuses);
}
