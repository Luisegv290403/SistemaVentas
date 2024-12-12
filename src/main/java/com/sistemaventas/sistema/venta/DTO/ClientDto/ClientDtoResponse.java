package com.sistemaventas.sistema.venta.DTO.ClientDto;

public class ClientDtoResponse {
    private Long id;
    private String name;
    private char[] dni;
    private String cellphone;
    private String address;
    private String ruc;
    private String email;
    

    public ClientDtoResponse(Long id, String name, char[] dni, String cellphone, String address, String ruc,
            String email) {
        this.id = id;
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
