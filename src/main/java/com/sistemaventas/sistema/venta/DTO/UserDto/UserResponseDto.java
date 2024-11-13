package com.sistemaventas.sistema.venta.DTO.UserDto;

import java.sql.Timestamp;



public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private Timestamp registration_date; // retorna fecha y hora para del proyecti
    private String gmail;
    private String userRol;
    private String apartment;

    public UserResponseDto(Long id,String name, String lastName, Timestamp registration_date, String gmail, String userRol,
            String apartment) {
        this.id = id;
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
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getUserRol() {
        return userRol;
    }
    public void setUserRol(String userRol) {
        this.userRol = userRol;
    }
    public String getApartment() {
        return apartment;
    }
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    

}
