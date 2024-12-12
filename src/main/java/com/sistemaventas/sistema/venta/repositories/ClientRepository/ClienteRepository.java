package com.sistemaventas.sistema.venta.repositories.ClientRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaventas.sistema.venta.entities.Client.Client;

public interface ClienteRepository extends JpaRepository<Client, Long>{

    
} 
