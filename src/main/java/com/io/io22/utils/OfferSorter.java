package com.io.io22.utils;

import com.io.io22.ceneo.dto.OfferDTO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OfferSorter {

    public static List<OfferDTO> getCeneoProductsSortedByPriceAscending(List<OfferDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(OfferDTO::getPrice))
                .collect(Collectors.toList());
    }

    public static List<OfferDTO> getCeneoProductsSortedByPriceDescending(List<OfferDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(OfferDTO::getPrice))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<OfferDTO> getCeneoProductsSortedByPriceAndShippingPriceAscending(List<OfferDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(offer -> offer.getShippingPrice() + offer.getPrice()))
                .collect(Collectors.toList());
    }

    public static List<OfferDTO> getCeneoProductsSortedByPriceAndShippingPriceDescending(List<OfferDTO> products) {
        return products.stream()
                .sorted(Comparator.comparing(offer -> offer.getShippingPrice() + offer.getPrice()))
                .collect(Collectors.toList());
    }

}
