package com.sistemaventas.sistema.venta.controllers.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaventas.sistema.venta.DTO.ServicesDto.ServicesDto;
import com.sistemaventas.sistema.venta.Services.Services.ServiceService;


@RestController
public class ServicesController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/addservices")
    private ResponseEntity<?> addServices(@RequestBody ServicesDto servicesDto){
        return serviceService.addServices(servicesDto);
    }

    @PutMapping("/editServices/{id}")
    private ResponseEntity<?> addServices(@PathVariable Long id, @RequestBody ServicesDto servicesDto){
        return serviceService.updateServices(id, servicesDto);
    }

    @GetMapping("/getServices")
    private ResponseEntity<?> getServices(){
        return serviceService.getServices();
    }
    
    @DeleteMapping("deleteservices/{id}")
    private ResponseEntity<?> deleteServices(@PathVariable Long id){
        return serviceService.delateServices(id);
    }

}
