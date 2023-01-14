package com.io.io22.ceneo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ProductDTO {
    @JsonFormat
    private String name;
    @JsonFormat
    private String thumbnailUrl;
    @JsonFormat
    private OfferDTO offer;

}
