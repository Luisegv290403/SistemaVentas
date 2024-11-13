package com.sistemaventas.sistema.venta.DTO.UserDto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;



public class UserDto {
    private String name;
    private String lastName;
    private Timestamp registration_date; // retorna fecha y hora para del proyecti
    private String gmail;
    private String userRol;
    private String apartment;
    private String passwordHash;
    private Set<Long> idRols;  // Colección de roles
    private Set<Long> idAparments;  // Colección de apartamentos
    private Set<String> rolsEdit = new HashSet<>();
    private Set<String> apartmentsEdit = new HashSet<>();
    
    public UserDto() {
    }


    public UserDto(String name, String lastName,Timestamp registration_date, String gmail, String userRol, String apartment) {
        this.name = name;
        this.lastName = lastName;
        this.registration_date = registration_date;
        this.gmail = gmail;
        this.userRol = userRol;
        this.apartment = apartment;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Timestamp getRegistration_date() {
        return registration_date;
    }
    public void setRegistration_date(Timestamp registration_date) {
        this.registration_date = registration_date;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getUserRols() {
        return userRol;
    }
    public void setUserRols(String userRol) {
        this.userRol = userRol;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getApartment() {
        return apartment;
    }


    public void setApartment(String apartment) {
        this.apartment = apartment;
    }


    public String getUserRol() {
        return userRol;
    }

    public void setUserRol(String userRol) {
        this.userRol = userRol;
    }

    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public Set<Long> getIdRols() {
        return idRols;
    }


    public void setIdRols(Set<Long> idRols) {
        this.idRols = idRols;
    }


    public Set<Long> getIdAparments() {
        return idAparments;
    }


    public void setIdAparments(Set<Long> idAparments) {
        this.idAparments = idAparments;
    }


    public Set<String> getRolsEdit() {
        return rolsEdit;
    }


    public void setRolsEdit(Set<String> rolsEdit) {
        this.rolsEdit = rolsEdit;
    }


    public Set<String> getApartmentsEdit() {
        return apartmentsEdit;
    }


    public void setApartmentsEdit(Set<String> apartmentsEdit) {
        this.apartmentsEdit= apartmentsEdit;
    }

    
    
}
