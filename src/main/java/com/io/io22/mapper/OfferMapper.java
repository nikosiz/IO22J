package com.io.io22.mapper;

import com.io.io22.ceneo.dto.ProductClusterDTO;
import com.io.io22.entity.OfferEntity;
import com.io.io22.model.ProductModel;

import java.util.List;
import java.util.stream.Collectors;

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


    public static List<ProductModel> toModel(List<ProductClusterDTO> productClusterDTOS) {
        return productClusterDTOS.stream()
                .map(OfferMapper::toModel)
                .collect(Collectors.toList());
    }

    public static ProductModel toModel(ProductClusterDTO productClusterDTO) {
        return ProductModel.builder()
                .searchProduct(productClusterDTO.getSearchProduct())
                .name(productClusterDTO.getResultProduct().getName())
                .price(productClusterDTO.getResultProduct().getOffer().getPrice())
                .shippingPrice(productClusterDTO.getResultProduct().getOffer().getShippingPrice())
                .seller(productClusterDTO.getResultProduct().getOffer().getSeller())
                .thumbnailUrl(productClusterDTO.getResultProduct().getThumbnailUrl())
                .redirectUrl(productClusterDTO.getResultProduct().getOffer().getRedirectUrl())
                .build();
    }
}
