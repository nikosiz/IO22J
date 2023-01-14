package com.io.io22.mapper;

import com.io.io22.entity.OfferEntity;
import com.io.io22.model.ProductModel;

public class OfferMapper {

    public static OfferEntity toOfferEntity(ProductModel productModel) {
        return new OfferEntity(
                productModel.getName(),
                productModel.getPrice(),
                productModel.getShippingPrice(),
                productModel.getSeller(),
                productModel.getThumbnailUrl(),
                productModel.getRedirectUrl()
        );
    }

}
