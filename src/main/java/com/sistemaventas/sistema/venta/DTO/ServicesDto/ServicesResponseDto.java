package com.sistemaventas.sistema.venta.DTO.ServicesDto;

public class ServicesResponseDto {
    private Long id;
    private String name;
    private String desciption;
    private boolean state;
    private String aparament;
    private double precie;
    
    public ServicesResponseDto(Long id, String name, String desciption, boolean state, String aparament,
    double precie) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.state = state;
        this.aparament = aparament;
        this.precie = precie;
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
    public String getDesciption() {
        return desciption;
    }
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getAparament() {
        return aparament;
    }
    public void setAparament(String aparament) {
        this.aparament = aparament;
    }
    public double getPrecie() {
        return precie;
    }
    public void setPrecie(double precie) {
        this.precie = precie;
    }

    
    
}
