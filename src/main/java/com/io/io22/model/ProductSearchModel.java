package com.io.io22.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchModel {

    private List<String> productsToSearch;

    public List<String> getProductsToSearch() {
        return productsToSearch;
    }
}
