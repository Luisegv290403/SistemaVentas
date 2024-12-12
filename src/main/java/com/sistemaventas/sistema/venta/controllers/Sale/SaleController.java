package com.sistemaventas.sistema.venta.controllers.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaventas.sistema.venta.DTO.SaleDto.SaleDto;
import com.sistemaventas.sistema.venta.Services.SaleServices.SaleServices;

@RestController
public class SaleController {
    @Autowired
    private SaleServices saleServices;

    @PostMapping("/addSale")
    private ResponseEntity<?> addSale(@RequestBody SaleDto saleDto){
        return saleServices.addSale(saleDto);
    }

}
