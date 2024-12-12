package com.sistemaventas.sistema.venta.repositories.ServicesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaventas.sistema.venta.entities.Service.Services;

public interface ServicesRepository extends JpaRepository<Services, Long>{

    
} 
