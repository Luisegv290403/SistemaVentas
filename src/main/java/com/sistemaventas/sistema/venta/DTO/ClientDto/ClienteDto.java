package com.sistemaventas.sistema.venta.DTO.ClientDto;



public class ClienteDto {
    
    private String name;

    private char[] dni;

    private String cellphone;


    private String address;


    private String ruc;


    private String email;

    

    public ClienteDto(String name, char[] dni, String cellphone, String address, String ruc, String email) {
        this.name = name;
        this.dni = dni;
        this.cellphone = cellphone;
        this.address = address;
        this.ruc = ruc;
        this.email = email;

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
