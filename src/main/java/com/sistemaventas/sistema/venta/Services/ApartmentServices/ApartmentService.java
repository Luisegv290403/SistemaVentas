package com.sistemaventas.sistema.venta.Services.ApartmentServices;

import com.sistemaventas.sistema.venta.DTO.AparmentDto.ApartmentDto;
import com.sistemaventas.sistema.venta.DTO.AparmentDto.ApartmentDtoResponse;
import com.sistemaventas.sistema.venta.entities.Apartment.Apartment;
import com.sistemaventas.sistema.venta.repositories.Apartment.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    public ResponseEntity<?> getAparments(){
        List<ApartmentDto> apartmentDtos = apartmentRepository.findAll().stream().map(apartment -> new ApartmentDto(
                apartment.getId_apartment(),
                apartment.getName(),
                apartment.getDescription()
        )).collect(Collectors.toList());
        HashMap<String, Object> aparments = new HashMap<>();
        aparments.put("aparments", apartmentDtos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(aparments);
    }

    public ResponseEntity<?> addApartment (ApartmentDtoResponse apartmentDtoResponse){
        Apartment apartment = new Apartment();
        apartment.setName(apartmentDtoResponse.getName());
        apartment.setDescription(apartmentDtoResponse.getDescription());
        apartmentRepository.save(apartment);
        HashMap<String, Object> response = new HashMap<>();
        response.put("response", apartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<?> uppdateAparment(Long id, ApartmentDtoResponse apartmentDtoResponse){
        Optional<Apartment> aparment = apartmentRepository.findById(id);
        if(aparment.isPresent()){
            aparment.get().setName(apartmentDtoResponse.getName());
            aparment.get().setDescription(apartmentDtoResponse.getDescription());
            apartmentRepository.save(aparment.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(aparment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("aparment not exit");
    }

    public ResponseEntity<?> delateAparment(Long id){
        Optional<Apartment> aparOptional = apartmentRepository.findById(id);

        if(aparOptional.isPresent()){
            apartmentRepository.deleteById(id);;
            
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aparamnet delate correctly");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error when delate Aparment");
    }
}
