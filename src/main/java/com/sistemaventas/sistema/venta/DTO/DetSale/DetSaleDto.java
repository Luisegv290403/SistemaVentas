package com.sistemaventas.sistema.venta.DTO.DetSale;

import com.sistemaventas.sistema.venta.entities.Sale.Sale;

public class DetSaleDto {
     private Sale sale;
     private Long servicesAparment;
     private int quantity;

     public DetSaleDto(Sale sale, Long servicesAparment, int quantity) {
          this.sale = sale;
          this.servicesAparment = servicesAparment;
          this.quantity = quantity;
     }

     public Sale getSale() {
          return sale;
     }

     public void setSale(Sale sale) {
          this.sale = sale;
     }

     public Long getServicesAparment() {
          return servicesAparment;
     }

     public void setServicesAparment(Long servicesAparment) {
          this.servicesAparment = servicesAparment;
     }

     public int getQuantity() {
          return quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }
}
