package com.example.authservice.mappers;

import com.example.authservice.dtos.AdminDTO;
import com.example.authservice.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
    AdminDTO adminToAdminDTO(Admin admin);
    Admin adminDTOToAdmin(AdminDTO adminDTO);
    Admin adminCreateDTOToAdmin(AdminDTO adminDTO);
    List<AdminDTO> adminsToAdminsDTOs(List<Admin> admins);
}
