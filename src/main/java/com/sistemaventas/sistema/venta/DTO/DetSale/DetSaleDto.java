package com.sistemaventas.sistema.venta.DTO.DetSale;

import com.sistemaventas.sistema.venta.entities.Sale.Sale;
import com.sistemaventas.sistema.venta.entities.ServicesAparament.ServicesAparment;

public class DetSaleDto {
     private Sale sale;
     private ServicesAparment servicesAparment;
     private int quantity;

     public DetSaleDto(Sale sale, ServicesAparment servicesAparment, int quantity) {
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
}
