package com.io.io22.mapper;

import com.io.io22.entity.OfferEntity;
import com.io.io22.model.AddToCartModel;

public class OfferMapper {

    public static OfferEntity mapToOfferEntity(AddToCartModel addToCartModel) {
        return new OfferEntity(
                addToCartModel.getName(),
                addToCartModel.getPrice(),
                addToCartModel.getShippingPrice(),
                addToCartModel.getSeller(),
                addToCartModel.getThumbnailUrl(),
                addToCartModel.getRedirectURL()
        );
    }
}
