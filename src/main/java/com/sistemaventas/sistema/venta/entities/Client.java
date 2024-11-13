package com.sistemaventas.sistema.venta.entities;

public class Client {
    private int id;
    private String name;
    private char dni;
    private String cellphone;
    private String adddres;
    private String ruc;
    private String gmail;

    
    public Client() {
    }
    public Client(int id, String name, char dni, String cellphone, String adddres, String ruc, String gmail) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.cellphone = cellphone;
        this.adddres = adddres;
        this.ruc = ruc;
        this.gmail = gmail;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getDni() {
        return dni;
    }
    public void setDni(char dni) {
        this.dni = dni;
    }
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getAdddres() {
        return adddres;
    }
    public void setAdddres(String adddres) {
        this.adddres = adddres;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
}
