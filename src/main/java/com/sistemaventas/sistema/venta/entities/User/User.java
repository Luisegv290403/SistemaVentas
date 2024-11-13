package com.sistemaventas.sistema.venta.entities.User;


import java.sql.Timestamp;
import java.util.Set;

import com.sistemaventas.sistema.venta.entities.Apartment.Apartment;
import com.sistemaventas.sistema.venta.entities.Rol.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;

    
    @Column(name="name", length = 150, nullable = false)
    private String name;
    @Column(name="lastname", length = 150, nullable = false)
    private String lastName;

    @Column(name="registration_date", nullable = false)
    private Timestamp registration_date;
    @Column(name="gmail", length = 254, nullable = false, unique = true)
    private String gmail;
    @Column(name="password_hash", nullable = false)
    private String password_hash;

    @ManyToMany
    @JoinTable(
        name = "User_rol",
        joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
        inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id")
    )
    private Set<Rol> userRols;
    @ManyToMany
    @JoinTable(
        name="User_apartment",
        joinColumns = @JoinColumn(name= "id_user", referencedColumnName = "id_user"),
        inverseJoinColumns = @JoinColumn(name = "id_apartment", referencedColumnName ="id_apartment")
    )
    private Set<Apartment> apartment;

    public User() {

    }
    
    /*public User(Long id_user, String name, Timestamp registration_date, String gmail, String password_hash) {
        this.id_user = id_user;
        this.name = name;
        this.registration_date = registration_date;
        this.gmail = gmail;
        this.password_hash = password_hash;
    }*/
    public User(String name, String lastName, Timestamp registration_date, String gmail, String password_hash) {
        this.name = name;
        this.lastName = lastName;
        this.registration_date = registration_date;
        this.gmail = gmail;
        this.password_hash = password_hash;
    }

    /*public User(String name, String lastName, String gmail, String password_hash,
            Set<Long> idRols,  Set<Long> idApartments) {
        this.name = name;
        this.lastName = lastName;
        this.gmail = gmail;
        this.password_hash = password_hash;
        this.idRols = idRols;
        this.idApartments = idApartments;
    }*/

    public Long getId_user() {
        return id_user;
    }
    public void setId_user(Long id_user) {
        this.id_user = id_user;
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

    public Set<Rol> getUserRols() {
        return userRols;
    }

    public void setUserRols(Set<Rol> userRols) {
        this.userRols = userRols;
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
    public String getPassword_hash() {
        return password_hash;
    }
    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Set<Apartment> getApartment() {
        return apartment;
    }

    public void setApartment(Set<Apartment> apartment) {
        this.apartment = apartment;
    }


      
}
