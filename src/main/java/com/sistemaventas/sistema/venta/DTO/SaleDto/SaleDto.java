package com.sistemaventas.sistema.venta.DTO.SaleDto;

import java.sql.Date;
import java.util.List;

import com.sistemaventas.sistema.venta.DTO.DetSale.DetSaleDto;
import com.sistemaventas.sistema.venta.entities.Client.Client;
import com.sistemaventas.sistema.venta.entities.DetSale.DetSale;

public class SaleDto {

    private String typeComprobant;

    private Date date;

    private Client client;

    private Long iduserApartments;

    private List<DetSaleDto> detSales;

    public SaleDto(String typeComprobant, Date date, Client client,
            Long iduserApartments, List<DetSaleDto> detSales) {
        this.typeComprobant = typeComprobant;
        this.date = date;
        this.client = client;
        this.iduserApartments = iduserApartments;
        this.detSales = detSales;
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


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getUserApartments() {
        return iduserApartments;
    }

    public void setUserApartments(Long iduserApartments) {
        this.iduserApartments = iduserApartments;
    }

    public List<DetSaleDto> getDetSales() {
        return detSales;
    }

    public void setDetSales(List<DetSaleDto> detSales) {
        this.detSales = detSales;
    }

}
