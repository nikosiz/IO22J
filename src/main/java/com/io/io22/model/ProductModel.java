package com.io.io22.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {

    private Long id;

    private String searchProduct;

    private String name;

    private Double price;

    private Double shippingPrice;

    private String seller;

    private String thumbnailUrl;

    private String redirectUrl;
}
