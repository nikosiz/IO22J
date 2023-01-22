package com.io.io22.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AddToCartDTO {
    @JsonFormat
    private String userEmail;
    @JsonFormat
    private String name;
    @JsonFormat
    private Double price;
    @JsonFormat
    private Double shippingPrice;
    @JsonFormat
    private String seller;
    @JsonFormat
    private String thumbnailUrl;
    @JsonFormat
    private String redirectUrl;
}
