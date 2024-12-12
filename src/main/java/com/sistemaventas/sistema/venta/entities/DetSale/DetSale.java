package com.sistemaventas.sistema.venta.entities.DetSale;


import com.sistemaventas.sistema.venta.entities.Sale.Sale;
import com.sistemaventas.sistema.venta.entities.ServicesAparament.ServicesAparment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="det_sale")
public class DetSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idDetsale;

    @ManyToOne
    @JoinColumn(name="sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="services_apartment", nullable = false)
    private ServicesAparment servicesAparment;

    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name="unit_precie", nullable = false)
    private double unitPrice;


    @Column(name="sub_total", nullable = false)
    private double subTotal;

    @Column(name="sub_total_igv", nullable = false)
    private double subTotalIgv;

     
    public DetSale() {
    }

    
    public DetSale(Sale sale, ServicesAparment servicesAparment, int quantity, double subTotal, double subTotalIgv, double unitPrice) {
        this.sale = sale;
        this.servicesAparment = servicesAparment;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.subTotalIgv = subTotalIgv;
        this.unitPrice = unitPrice;
    }


    public Long getIdDetsale() {
        return idDetsale;
    }

    public Sale getVenta() {
        return sale;
    }

    public void setVenta(Sale sale) {
        this.sale = sale;
    }

    public ServicesAparment getServicesAparment() {
        return servicesAparment;
    }

    public void setServicesAparment(ServicesAparment servicesAparment) {
        this.servicesAparment = servicesAparment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotalIgv() {
        return subTotalIgv;
    }

    public void setSubTotalIgv(double subTotalIgv) {
        this.subTotalIgv = subTotalIgv;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setIdDetsale(Long idDetsale) {
        this.idDetsale = idDetsale;
    }

    


}
