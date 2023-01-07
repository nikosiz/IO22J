package com.io.io22.service;

import com.io.io22.entity.SearchHistoryEntity;
import com.io.io22.repository.SearchHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;

    public SearchHistoryService(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    public Collection<SearchHistoryEntity> getByUsersEmail(String email) {
        return searchHistoryRepository.findByUserEntity_Email(email);
    }
}
