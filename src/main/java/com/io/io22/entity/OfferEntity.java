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

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "shipping_price")
    private Double shippingPrice;

    @Column(name = "seller")
    private String seller;

    @Column(name = "thumbnail_link")
    private String thumbnailUrl;

    @Column(name = "redirect_url")
    private String redirectURL;

    public OfferEntity() {
    }

    public OfferEntity(String name, Double price, Double shippingPrice, String seller, String thumbnailUrl, String redirectURL) {
        this.name = name;
        this.price = price;
        this.shippingPrice = shippingPrice;
        this.seller = seller;
        this.thumbnailUrl = thumbnailUrl;
        this.redirectURL = redirectURL;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public String getSeller() {
        return seller;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getRedirectURL() {
        return redirectURL;
    }
}
