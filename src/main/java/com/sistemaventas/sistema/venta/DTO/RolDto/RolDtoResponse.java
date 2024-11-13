package com.sistemaventas.sistema.venta.DTO.RolDto;


public class RolDtoResponse {
    private String rol;
    private String description;

    
    public RolDtoResponse(String rol, String description) {
        this.rol = rol;
        this.description = description;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
