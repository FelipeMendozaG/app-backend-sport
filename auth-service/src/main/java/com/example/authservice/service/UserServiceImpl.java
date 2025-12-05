package com.example.authservice.service;

import com.example.authservice.dtos.*;
import com.example.authservice.exceptions.EmailAlreadyExistsException;
import com.example.authservice.mappers.AdminMapper;
import com.example.authservice.mappers.UserMapper;
import com.example.authservice.model.Admin;
import com.example.authservice.model.User;
import com.example.authservice.repository.AdminRepository;
import com.example.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AdminRepository adminRepository;
    private final AdminService adminService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AdminService adminService, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.adminService = adminService;
        this.adminRepository = adminRepository;
    }
    @Override
    public List<UserDTO> listUsers() {
        return UserMapper.INSTANCE.usersToUserDTOs(this.userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(int id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.map(UserMapper.INSTANCE::userToUserDTO).orElse(null);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        return user.map(UserMapper.INSTANCE::userToUserDTO).orElse(null);
    }

    @Override
    public UserDTO saveUser(UserCreateDTO  userCreateDTO) {
        User user = UserMapper.INSTANCE.userCreateDTOToUser(userCreateDTO);
        if (userCreateDTO.getEmail() != null) {
            if (this.userRepository.existsByEmail(userCreateDTO.getEmail())) {
                throw new EmailAlreadyExistsException("El email ya está en uso: " + userCreateDTO.getEmail());
            }
            user.setEmail(userCreateDTO.getEmail());
        }
        String hashedPassword = this.passwordEncoder.encode(userCreateDTO.getPassword());
        user.setPassword(hashedPassword);
        User responseEntity = this.userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(responseEntity);
    }

    @Override
    public UserDTO updateUser(UserUpdateDTO userUpdateDTO) {
        User existingUser = userRepository.findById(userUpdateDTO.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + userUpdateDTO.getId()));
        if (userUpdateDTO.getName() != null) {
            existingUser.setName(userUpdateDTO.getName());
        }
        if (userUpdateDTO.getEmail() != null) {
            if (!existingUser.getEmail().equals(userUpdateDTO.getEmail()) &&
                    userRepository.existsByEmail(userUpdateDTO.getEmail())) {
                throw new EmailAlreadyExistsException("El email ya está en uso: " + userUpdateDTO.getEmail());
            }
            existingUser.setEmail(userUpdateDTO.getEmail());
        }
        if (userUpdateDTO.getPhone() != null) {
            existingUser.setPhone(userUpdateDTO.getPhone());
        }
        User responseEntity = this.userRepository.save(existingUser);
        return UserMapper.INSTANCE.userToUserDTO(responseEntity);
    }

    @Override
    public String deleteUser(int id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "Registro eliminado";
        }
        return "No se pudo elminar el registro";
    }

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + loginDTO.getEmail()));
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        // return new LoginResponseDTO(userDTO, "Login exitoso", true);
        Admin admin=this.adminRepository.findByUserId(userDTO.getId());
        String token = this.jwtService.generateToken(user.getEmail());
        if(admin==null){
            return new LoginResponseDTO(token, userDTO, "Login exitoso", true);
        }
        AdminDTO adminDTO = AdminMapper.INSTANCE.adminToAdminDTO(admin);
        return new LoginResponseDTO(token, userDTO, "Login exitoso", true, adminDTO);
    }
}
