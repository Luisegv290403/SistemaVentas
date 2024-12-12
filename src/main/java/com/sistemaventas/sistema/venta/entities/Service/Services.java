package com.sistemaventas.sistema.venta.entities.Service;

import java.util.Set;

import com.sistemaventas.sistema.venta.entities.ServicesAparament.ServicesAparment;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_services;
    @Column(name="name", nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "service")
    private Set<ServicesAparment> servicesAparments; 
    
    public Services() {
    }
    public Services(Long id_service, String name) {
        this.id_services = id_service;
        this.name = name;
    }
    public Long getId_service() {
        return id_services;
    }
    public void setId_service(Long id_service) {
        this.id_services = id_service;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<ServicesAparment> getServicesAparments() {
        return servicesAparments;
    }
    public void setServicesAparments(Set<ServicesAparment> servicesAparments) {
        this.servicesAparments = servicesAparments;
    }
    
}
