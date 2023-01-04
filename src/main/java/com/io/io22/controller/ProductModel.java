package com.io.io22.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {

    Long id;
    String name;
    Double price;
    Double shippingPrice;
    String seller;
    String link;
}
