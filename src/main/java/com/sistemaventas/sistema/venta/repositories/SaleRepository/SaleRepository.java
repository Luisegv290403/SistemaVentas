package com.sistemaventas.sistema.venta.repositories.SaleRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaventas.sistema.venta.entities.Sale.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    
    
} 
