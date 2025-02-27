package com.sistemaventas.sistema.venta.repositories.UserRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sistemaventas.sistema.venta.entities.User.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    

}
