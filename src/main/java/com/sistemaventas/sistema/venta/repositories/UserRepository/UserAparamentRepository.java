package com.sistemaventas.sistema.venta.repositories.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaventas.sistema.venta.entities.User.UserAparament;

@Repository
public interface UserAparamentRepository extends JpaRepository<UserAparament, Long>{
    
}
