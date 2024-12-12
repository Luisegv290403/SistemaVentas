package com.sistemaventas.sistema.venta.DTO.SaleDto;

import java.sql.Date;

import com.sistemaventas.sistema.venta.entities.Client.Client;

public class SaleResponseDto {
    private Long idSaleDto;

    private String typeComprobant;

    private Date date;

    private String nrComprobant;


    private Client client;

    private Long iduserApartments;

    private Double total;

    
    public SaleResponseDto(Long idSaleDto, String typeComprobant, Date date, String nrComprobant, Client client,
            Long iduserApartments, Double total) {
        this.idSaleDto = idSaleDto;
        this.typeComprobant = typeComprobant;
        this.date = date;
        this.nrComprobant = nrComprobant;
        this.client = client;
        this.iduserApartments = iduserApartments;
        this.total = total;
    }

    public Long getIdSaleDto() {
        return idSaleDto;
    }

    public void setIdSaleDto(Long idSaleDto) {
        this.idSaleDto = idSaleDto;
    }

    public String getTypeComprobant() {
        return typeComprobant;
    }

    public void setTypeComprobant(String typeComprobant) {
        this.typeComprobant = typeComprobant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNrComprobant() {
        return nrComprobant;
    }

    public void setNrComprobant(String nrComprobant) {
        this.nrComprobant = nrComprobant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getIduserApartments() {
        return iduserApartments;
    }

    public void setIduserApartments(Long iduserApartments) {
        this.iduserApartments = iduserApartments;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    

    
}
