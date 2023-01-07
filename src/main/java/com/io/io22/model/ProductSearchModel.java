package com.io.io22.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchModel {

    private String product1;

    private String product2;

    private String product3;

    private String product4;

    private String product5;

    private String product6;

    private String product7;


    public List<String> getAllProductsName() {
        return List.of(product1, product2, product3, product4, product5, product6, product7);
    }
}
