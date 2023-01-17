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

    private static String getCeneoProductsUrl(List<String> productNames, SortEnum sortEnum) {
        return UriComponentsBuilder
                .fromHttpUrl(URL)
                .path(SEARCH)
                .queryParam(PRODUCT_PARAM, productNames)
                .queryParam(SORTING_PARAM, sortEnum.getValue())
                .build(false)
                .toUriString();
    }

    public List<ProductClusterDTO> queryCeneoProductsResult(List<String> productNames, SortEnum sortEnum) {
        ResponseEntity<List<ProductClusterDTO>> exchange = restTemplate.exchange(
                getCeneoProductsUrl(productNames, sortEnum),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return exchange.getBody();
    }
}
