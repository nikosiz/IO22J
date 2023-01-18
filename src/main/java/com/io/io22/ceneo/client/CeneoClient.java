package com.io.io22.ceneo.client;

import com.io.io22.ceneo.dto.ProductClusterDTO;
import com.io.io22.utils.SortEnum;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Component
public class CeneoClient {

    private static final String URL = "http://localhost:5000/";
    private static final String SEARCH = "search";
    private static final String PRODUCT_PARAM = "product";
    private static final String SORTING_PARAM = "sorting";

    private final RestTemplate restTemplate;

    public CeneoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductClusterDTO> queryCeneoProductsResult(List<String> productNames, Optional<SortEnum> sortEnum) {
        ResponseEntity<List<ProductClusterDTO>> exchange = restTemplate.exchange(
                getCeneoProductsUrl(productNames, sortEnum),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return exchange.getBody();
    }

    private String getCeneoProductsUrl(List<String> productNames, Optional<SortEnum> sortEnum) {
        return UriComponentsBuilder
                .fromHttpUrl(URL)
                .path(SEARCH)
                .queryParam(PRODUCT_PARAM, productNames)
                .queryParam(SORTING_PARAM, sortEnum.orElse(SortEnum.BY_SHOPS).getValue())
                .build(false)
                .toUriString();
    }
}
