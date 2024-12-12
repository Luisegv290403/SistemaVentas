package com.sistemaventas.sistema.venta.controllers.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaventas.sistema.venta.DTO.ClientDto.ClienteDto;
import com.sistemaventas.sistema.venta.Services.ClientServices.ClientServices;

@RestController
public class ClientController {
    
    @Autowired
    private ClientServices clientServices;

    @RequestMapping("/getusers")
    private ResponseEntity<?> getClient(){
        return clientServices.getClient();
    }

    @PutMapping("/edituser/{id}")
    private ResponseEntity<?> editClient(@PathVariable Long id, @RequestBody ClienteDto clienteDto){
        return clientServices.editClient(id, clienteDto);
    }
    @DeleteMapping("/deleteuser/{id}")
    private ResponseEntity<?> deleteClient(@PathVariable Long id){
        return clientServices.deleteClient(id);
    }
}
