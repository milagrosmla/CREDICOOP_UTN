package com.credicoop.utn.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Long orderNumber;
    @Column(name = "order_date", columnDefinition = "DATE")
    private LocalDate orderDate;
    @Column(name = "ship_date", columnDefinition = "DATE")
    private LocalDate shipDate;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "order_amount")
    private BigDecimal orderAmount;



    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Order order;

    @OneToMany(targetEntity = ShoppingCart.class)
    @JoinColumn(name = "order_number_fk",referencedColumnName = "order_number")
    private List<ShoppingCart> shoppingCartList;

}
