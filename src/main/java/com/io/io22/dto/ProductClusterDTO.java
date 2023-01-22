package com.io.io22.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ProductClusterDTO {

    @JsonFormat
    private String searchProduct;

    @JsonFormat
    private ProductDTO resultProduct;

}
