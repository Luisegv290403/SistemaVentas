package com.sistemaventas.sistema.venta.entities.Sale;

import java.sql.Date;
import java.util.List;

import com.sistemaventas.sistema.venta.entities.Client.Client;
import com.sistemaventas.sistema.venta.entities.DetSale.DetSale;
import com.sistemaventas.sistema.venta.entities.User.UserAparament;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sale")
    private Long id_sale;

    @Column(name = "type_comprobant", length = 7)
    private String typeComprobant;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "nr_comprobant", length = 200, nullable = false)
    private String nrComprobant;

    @Column(name = "total", nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_apartment", referencedColumnName = "id")
    private UserAparament userApartments;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetSale> detSales;


    public Sale() {
    }

    public Sale(String typeComprobant, Date date, String nrComprobant, Client client,
            UserAparament userApartments, Double total, List<DetSale> detSales) {
        this.typeComprobant = typeComprobant;
        this.date = date;
        this.nrComprobant = nrComprobant;
        this.client = client;
        this.userApartments = userApartments;
        this.total = total;
        this.detSales = detSales;
    }

    public Long getId() {
        return id_sale;
    }

    public void setId(Long id) {
        this.id_sale = id;
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

    public UserAparament getUserApartments() {
        return userApartments;
    }

    public void setUserApartments(UserAparament userApartments) {
        this.userApartments = userApartments;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetSale> getDetSales() {
        return detSales;
    }

    public void setDetSales(List<DetSale> detSales) {
        this.detSales = detSales;
    }

}
