package com.sistemaventas.sistema.venta.entities;

public class Services {
    private int id_service;
    private String name;

    
    public Services() {
    }
    public Services(int id_service, String name) {
        this.id_service = id_service;
        this.name = name;
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
