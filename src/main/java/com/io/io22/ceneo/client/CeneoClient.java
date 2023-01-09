package com.io.io22.ceneo.client;

import com.io.io22.ceneo.dto.ProductClusterDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CeneoClient {

    private static final String URL = "";

    private final RestTemplate restTemplate;

    public CeneoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductClusterDTO> queryCeneoProductsResult(List<String> productNames) {
        return restTemplate.exchange(URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductClusterDTO>>() {
                },
                productNames).getBody();
    }
}
