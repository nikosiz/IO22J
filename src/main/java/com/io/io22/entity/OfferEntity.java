package com.io.io22.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class OfferEntity {

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

    private String redirectURL;

    public OfferEntity(String name, Double price, Double shippingPrice, String seller, String thumbnailUrl, String redirectURL) {
        this.name = name;
        this.price = price;
        this.shippingPrice = shippingPrice;
        this.seller = seller;
        this.thumbnailUrl = thumbnailUrl;
        this.redirectURL = redirectURL;
    }
}
