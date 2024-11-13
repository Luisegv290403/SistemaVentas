package com.sistemaventas.sistema.venta.entities.Rol;

import java.util.Set;

import com.sistemaventas.sistema.venta.entities.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rol", length = 50)
    private String rol;

    @Column(name="description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userRols")
    private Set<User> users;
    
    public Rol() {
    }

    
    public Rol(Long id, String rol, String description) {
        this.id = id;
        this.rol = rol;
        this.description = description;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    
}
