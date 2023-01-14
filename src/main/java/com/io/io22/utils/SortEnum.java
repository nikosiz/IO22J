package com.io.io22.utils;

public enum SortEnum {
    BY_PRICE(0),
    BY_SHOPS(1);

    private final Integer sortBy;

    SortEnum(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getValue() {
        return sortBy;
    }
}
