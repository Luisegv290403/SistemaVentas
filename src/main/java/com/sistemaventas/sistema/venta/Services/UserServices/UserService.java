package com.sistemaventas.sistema.venta.Services.UserServices;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemaventas.sistema.venta.DTO.UserDto.UserDto;
import com.sistemaventas.sistema.venta.DTO.UserDto.UserResponseDto;
import com.sistemaventas.sistema.venta.entities.Apartment.Apartment;
import com.sistemaventas.sistema.venta.entities.Rol.Rol;
import com.sistemaventas.sistema.venta.entities.User.User;
import com.sistemaventas.sistema.venta.repositories.Apartment.ApartmentRepository;
import com.sistemaventas.sistema.venta.repositories.RolRepository.RolRepository;
import com.sistemaventas.sistema.venta.repositories.UserRepository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    public List<UserResponseDto> getAllUser() {

        return userRepository.findAll()
                .stream().map(user -> new UserResponseDto(
                        user.getId_user(),
                        user.getName(),
                        user.getLastName(),
                        user.getRegistration_date(),
                        user.getGmail(),
                        user.getUserRols().stream().map(Rol::getRol)
                                .collect(Collectors.joining(", ")),
                        user.getApartment().stream().map(Apartment::getName)
                                .collect(Collectors.joining(", "))))
                .collect(Collectors.toList());

    }

    @Transactional
    public User addUser(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setGmail(userDto.getGmail());
        user.setRegistration_date(new Timestamp(System.currentTimeMillis()));
        user.setPassword_hash(userDto.getPasswordHash());

        // Get Rol for ID and add a User
        Set<Rol> roles = new HashSet<>(rolRepository.findAllById(userDto.getIdRols()));
        user.setUserRols(roles);

        // Get Apartment for ID and add a User
        Set<Apartment> apartments = new HashSet<>(apartmentRepository.findAllById(userDto.getIdAparments()));
        user.setApartment(apartments);
        userRepository.save(user);
        return user;
    }

    public ResponseEntity<?> updateUser(Long id, UserDto userDto) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {

            // Actualizar los campos del usuario
            user.get().setName(userDto.getName());
            user.get().setLastName(userDto.getLastName());
            user.get().setRegistration_date(userDto.getRegistration_date());
            user.get().setGmail(userDto.getGmail());
            user.get().setPassword_hash(userDto.getPasswordHash());
            // Get Rol for ID and add a User
            Set<Rol> roles = new HashSet<>(rolRepository.findAllById(userDto.getIdRols()));
            user.get().setUserRols(roles);

            // Get Apartment for ID and add a User
            Set<Apartment> apartments = new HashSet<>(apartmentRepository.findAllById(userDto.getIdAparments()));
            user.get().setApartment(apartments);
            // Guardar los cambios en el repositorio
            userRepository.save(user.get());

            return ResponseEntity.ok("Usuario editado: " + user.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

    }

    public ResponseEntity<?> deleteUser(Long id){
        
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok("usuario eliminado Correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Usuario no eliminado");
        }

    }
}
