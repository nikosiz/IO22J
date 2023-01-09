package com.io.io22.ceneo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private String ceneoUrl;

    private String thumbnailUrl;

    private List<OfferDTO> offers;

}
