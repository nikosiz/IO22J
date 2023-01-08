package com.io.io22.ceneo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductClusterDTO {

    private String searchProduct;
    private List<ProductDTO> products;

}
