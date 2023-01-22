package com.io.io22.mapper;

import com.io.io22.dto.AddToCartDTO;
import com.io.io22.entity.OfferEntity;

public class OfferMapper {

    public static OfferEntity toOfferEntity(AddToCartDTO addToCartDTO) {
        return new OfferEntity(
                addToCartDTO.getName(),
                addToCartDTO.getPrice(),
                addToCartDTO.getShippingPrice(),
                addToCartDTO.getSeller(),
                addToCartDTO.getThumbnailUrl(),
                addToCartDTO.getRedirectUrl()
        );
    }

}
