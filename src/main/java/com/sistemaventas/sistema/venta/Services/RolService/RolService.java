package com.sistemaventas.sistema.venta.Services.RolService;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemaventas.sistema.venta.DTO.RolDto.RolDto;
import com.sistemaventas.sistema.venta.DTO.RolDto.RolDtoResponse;

import com.sistemaventas.sistema.venta.entities.Rol.Rol;
import com.sistemaventas.sistema.venta.repositories.RolRepository.RolRepository;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;



    public ResponseEntity<?> getRols(){
        List<RolDto> rolDtos = rolRepository.findAll().stream().map(rol -> new RolDto(
            rol.getId(), 
            rol.getRol(), 
            rol.getDescription()
            )).collect(Collectors.toList()); 
        HashMap<String, Object> rols = new HashMap<>();

        rols.put("roles", rolDtos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(rols);
    }

    public ResponseEntity<?> addRols(RolDtoResponse rolDtoResponse){
        Rol rol = new Rol();
        rol.setRol(rolDtoResponse.getRol());
        rol.setDescription(rolDtoResponse.getDescription());
        rolRepository.save(rol);

        HashMap<String, Object> response = new HashMap<>();
        response.put("roles", rolRepository.findAll());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    
    public ResponseEntity<?> updateRol(Long id, RolDtoResponse rolDtoResponse){
        Optional<Rol> rol = rolRepository.findById(id);

        if(rol.isPresent()){
            rol.get().setRol(rolDtoResponse.getRol());
            rol.get().setDescription(rolDtoResponse.getDescription());
            rolRepository.save(rol.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(rol.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("rol not edit");
    }
    
    public ResponseEntity<?> delateRol(Long id){
        Optional<Rol> rol = rolRepository.findById(id);

        if(rol.isPresent()){
            rolRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Rol eliminado");
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("rol not exist");
    }
}
