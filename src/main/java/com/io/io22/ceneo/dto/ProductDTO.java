package com.io.io22.ceneo.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;

    private Double price;

    private Double shippingPrice;

    private String seller;

    private String thumbnailUrl;

    private String url;

}
