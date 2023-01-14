package com.io.io22.ceneo.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private String thumbnailUrl;

    private OfferDTO offer;

}
