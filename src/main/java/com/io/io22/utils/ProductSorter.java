package com.io.io22.utils;

import com.io.io22.ceneo.dto.ProductDTO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSorter {

    public static List<ProductDTO> getCeneoProductsSortedByPriceAscending(List<ProductDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice))
                .collect(Collectors.toList());
    }

    public static List<ProductDTO> getCeneoProductsSortedByPriceDescending(List<ProductDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<ProductDTO> getCeneoProductsSortedByPriceAndShippingPriceAscending(List<ProductDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(product -> product.getShippingPrice() + product.getPrice()))
                .collect(Collectors.toList());
    }

    public static List<ProductDTO> getCeneoProductsSortedByPriceAndShippingPriceDescending(List<ProductDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(product -> product.getShippingPrice() + product.getPrice()))
                .collect(Collectors.toList());
    }

}
