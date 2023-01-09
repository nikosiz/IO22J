package com.io.io22.utils;

public enum Sort {
    PRICE_ASC("Lowest price"),
    PRICE_DESC("Highest price"),
    PRICE_AND_SHIPPING_PRICE_ASC("Lowest price with delivery"),
    PRICE_AND_SHIPPING_PRICE_DESC("Highest price with delivery");

    private final String sortBy;

    Sort(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortBy() {
        return sortBy;
    }
}
