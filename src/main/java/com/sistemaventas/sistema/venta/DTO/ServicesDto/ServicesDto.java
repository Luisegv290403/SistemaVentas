package com.sistemaventas.sistema.venta.DTO.ServicesDto;

import java.util.Set;


public class ServicesDto {
    private String name;
    private String[] description;
    private Double[] precie;
    private boolean[] state;
    private Set<Long> apartmentId ; // mandaremos array de ids mi king



    public ServicesDto() {
    }
    public ServicesDto(String name, String[] description, Double[] precie, boolean[] state, Set<Long> apartmentId) {
        this.name = name;
        this.description = description;
        this.precie = precie;
        this.state = state;
        this.apartmentId = apartmentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getDescription() {
        return description;
    }
    public void setDescription(String[] description) {
        this.description = description;
    }
    public Double[] getPrecie() {
        return precie;
    }
    public void setPrecie(Double[] precie) {
        this.precie = precie;
    }
    public boolean[] isState() {
        return state;
    }
    public void setState(boolean[] state) {
        this.state = state;
    }
    public Set<Long> getApartmentId() {
        return apartmentId;
    }
    public void setApartmentId(Set<Long> apartmentId) {
        this.apartmentId = apartmentId;
    }

    


  
}
