package com.sistemaventas.sistema.venta.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaventas.sistema.venta.DTO.RolDto.RolDtoResponse;
import com.sistemaventas.sistema.venta.Services.RolService.RolService;

@RestController
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping("/rols")
    public ResponseEntity<?> getRols(){
        return rolService.getRols();
    }
    @PostMapping("/addRol")
    private ResponseEntity<?> addRol(@RequestBody RolDtoResponse rolDtoResponse){
        return rolService.addRols(rolDtoResponse);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateRol(@PathVariable Long id, @RequestBody RolDtoResponse rolDtoResponse){
        return rolService.updateRol(id, rolDtoResponse);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delateRol(@PathVariable Long id){
        return rolService.delateRol(id);
    }
}
