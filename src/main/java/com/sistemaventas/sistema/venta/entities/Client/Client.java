package com.sistemaventas.sistema.venta.entities.Client;




import java.util.Set;

import com.sistemaventas.sistema.venta.entities.Sale.Sale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 150)
    private String name;
    @Column(name="dni", nullable = false, unique = true)
    private char[] dni;

    @Column(name="cellphone", nullable = false, length = 20, unique = true)
    private String cellphone;

    @Column(name="address", nullable = false, length = 220)
    private String address;

    @Column(name="ruc", nullable = false, length = 50)
    private String ruc;

    @Column(name = "gmail", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Sale> sales;

    public Client(){

    }
    

    public Client(String name, char[] dni, String cellphone, String address, String ruc, String email) {
        this.name = name;
        this.dni = dni;
        this.cellphone = cellphone;
        this.address = address;
        this.ruc = ruc;
        this.email = email;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getDni() {
        return dni;
    }

    public void setDni(char[] dni) {
        this.dni = dni;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
