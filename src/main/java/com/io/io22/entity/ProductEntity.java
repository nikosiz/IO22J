package com.io.io22.entity;


import javax.persistence.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Double price;

    private Double shippingPrice;

    private String seller;

    private String URL;

}
