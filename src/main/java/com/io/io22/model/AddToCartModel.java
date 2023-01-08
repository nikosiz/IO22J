package com.io.io22.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddToCartModel {

    private String name;

    private Double price;

    private Double shippingPrice;

    private String seller;

    private String thumbnailUrl;

    private String redirectURL;

    public AddToCartModel() {
    }
}
