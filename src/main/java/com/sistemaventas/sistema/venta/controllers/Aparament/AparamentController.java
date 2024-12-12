package com.sistemaventas.sistema.venta.controllers.Aparament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaventas.sistema.venta.DTO.AparmentDto.ApartmentDtoResponse;
import com.sistemaventas.sistema.venta.Services.ApartmentServices.ApartmentService;

@RestController
@RequestMapping("/aparment")
public class AparamentController {
    
    @Autowired
    private ApartmentService apartmentService;

      
    @GetMapping("/")
    public ResponseEntity<?> getAparaments(){
        return apartmentService.getAparments();
    }
    @PostMapping("/addAparament")
    private ResponseEntity<?> addRol(@RequestBody ApartmentDtoResponse apartmentDtoResponse){
        return apartmentService.addApartment(apartmentDtoResponse);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateRol(@PathVariable Long id, @RequestBody ApartmentDtoResponse apartmentDtoResponse){
        return apartmentService.uppdateAparment(id, apartmentDtoResponse);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delateRol(@PathVariable Long id){
        return apartmentService.delateAparment(id);
    }


}
