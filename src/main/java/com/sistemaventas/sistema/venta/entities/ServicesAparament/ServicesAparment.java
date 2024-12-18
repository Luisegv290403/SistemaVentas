package com.sistemaventas.sistema.venta.entities.ServicesAparament;

import com.sistemaventas.sistema.venta.entities.Apartment.Apartment;
import com.sistemaventas.sistema.venta.entities.DetSale.DetSale;
import com.sistemaventas.sistema.venta.entities.Service.Services;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Services_apartment")
public class ServicesAparment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="precio", precision = 2)
    private double precie;
    @Column(name = "state", nullable = false)
    private boolean state;

    // de muchos a uno
    @ManyToOne
    @JoinColumn(name = "id_services",referencedColumnName = "id_services")
    private Services service;
    // de muchos a uno siki por la id
    @ManyToOne
    @JoinColumn(name="id_apartment", referencedColumnName = "id_apartment")
    private Apartment apartment;
    


    
    public ServicesAparment(Long id, String description, double precie, boolean state, Services service,
            Apartment apartment) {
        this.id = id;
        this.description = description;
        this.precie = precie;
        this.state = state;
        this.service = service;
        this.apartment = apartment;
    }

    public ServicesAparment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrecie() {
        return precie;
    }

    public void setPrecie(double precie) {
        this.precie = precie;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
    
}
