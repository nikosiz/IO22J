package com.io.io22.ceneo.dto;

import lombok.Data;

@Data
public class OfferDTO {

    private Double price;

    private Double shippingPrice;

    private String seller;

    private String redirectUrl;
}
