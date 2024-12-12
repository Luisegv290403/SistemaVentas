package com.sistemaventas.sistema.venta.entities.Apartment;

import java.util.Set;


import com.sistemaventas.sistema.venta.entities.ServicesAparament.ServicesAparment;
import com.sistemaventas.sistema.venta.entities.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_apartment;
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="description", nullable = true)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "apartment")
    private Set<User> users;

    @OneToMany(mappedBy = "apartment")
    private Set<ServicesAparment> servicesAparments;

    
    public Apartment() {
    }

    public Apartment(Long id_apartment, String name, String description) {
        this.id_apartment = id_apartment;
        this.name = name;
        this.description = description;
    }
    public Long getId_apartment() {
        return id_apartment;
    }
    public void setId_apartment(Long id_apartment) {
        this.id_apartment = id_apartment;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    
}
