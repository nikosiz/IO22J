package com.io.io22.ceneo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductClusterDTO {

    private String name;

    private String uri;

    private List<ProductDTO> offers;

}
