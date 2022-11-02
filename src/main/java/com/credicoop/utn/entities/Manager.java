package com.credicoop.utn.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity(name = "manager")
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "emails")
    private String email;



    @ManyToMany
    private List<PaymentMethod> paymentMethod;

    @OneToMany(mappedBy = "manager")
    private List<Product> productList;
    public Manager(){

        this.paymentMethod = new ArrayList<>();
        this.productList = new ArrayList<>();

    }

}
