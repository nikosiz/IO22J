package com.io.io22.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class OfferDTO {

    @JsonFormat
    private Double price;
    @JsonFormat
    private Double shippingPrice;
    @JsonFormat
    private String seller;
    @JsonFormat
    private String redirectUrl;
}
