package com.io.io22.service;

import com.io.io22.repository.SearchHistoryClusterRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchHistoryClusterService {

    private final SearchHistoryClusterRepository searchHistoryClusterRepository;

    public SearchHistoryClusterService(SearchHistoryClusterRepository searchHistoryClusterRepository) {
        this.searchHistoryClusterRepository = searchHistoryClusterRepository;
    }
}
