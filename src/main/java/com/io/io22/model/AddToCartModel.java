package com.io.io22.model;

import lombok.Data;

@Data
public class AddToCartModel {

    private String name;

    private Double price;

    private Double shippingPrice;

    private String seller;

    private String thumbnailUrl;

    private String redirectURL;

}
