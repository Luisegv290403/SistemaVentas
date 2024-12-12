package com.sistemaventas.sistema.venta.entities.User;

import java.util.Set;

import com.sistemaventas.sistema.venta.entities.Apartment.Apartment;
import com.sistemaventas.sistema.venta.entities.Sale.Sale;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="User_apartment")
public class UserAparament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_apartment", referencedColumnName = "id_apartment")
    private Apartment apartment;



    @OneToMany(mappedBy = "userApartments")
    private Set<Sale> sale;



    public UserAparament() {
    }



    public UserAparament(User user, Apartment apartment) {
        this.user = user;
        this.apartment = apartment;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    
    
}
