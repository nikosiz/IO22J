package com.io.io22.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Double price;

    @Column(name = "shipping_price")
    private Double shippingPrice;

    private String seller;

    @Column(name = "thumbnail_link")
    private String thumbnailUrl;

    private String url;

}
