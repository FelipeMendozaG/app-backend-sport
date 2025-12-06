package com.example.authservice.mappers;

import com.example.authservice.dtos.UserCreateDTO;
import com.example.authservice.dtos.UserDTO;
import com.example.authservice.dtos.UserUpdateDTO;
import com.example.authservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel ="spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    User userCreateDTOToUser(UserCreateDTO userCreateDTO);
    @Mapping(target = "password", ignore = true)
    User userUpdateDTOToUser(UserUpdateDTO userUpdateDTO);
    List<UserDTO> usersToUserDTOs(List<User> users);
}
