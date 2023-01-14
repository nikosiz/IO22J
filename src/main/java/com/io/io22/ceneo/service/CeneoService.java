package com.io.io22.ceneo.service;

import com.io.io22.ceneo.client.CeneoClient;
import com.io.io22.ceneo.dto.ProductClusterDTO;
import com.io.io22.utils.SortEnum;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CeneoService {

    private final CeneoClient ceneoClient;

    public CeneoService(CeneoClient ceneoClient) {
        this.ceneoClient = ceneoClient;
    }

    public List<ProductClusterDTO> getCeneoProducts(List<String> searchProducts, SortEnum sortEnum) {
        if (searchProducts.isEmpty()) {
            return Collections.emptyList();
        }
        return ceneoClient.queryCeneoProductsResult(searchProducts, sortEnum);
    }

}
