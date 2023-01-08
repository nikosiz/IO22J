package com.io.io22.service;

import com.io.io22.entity.SearchHistoryEntity;
import com.io.io22.entity.UserEntity;
import com.io.io22.exception.UserNotFoundException;
import com.io.io22.repository.SearchHistoryRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;

    private final UserService userService;

    public SearchHistoryService(SearchHistoryRepository searchHistoryRepository, UserService userService) {
        this.searchHistoryRepository = searchHistoryRepository;
        this.userService = userService;
    }

    public void addIfUserAuthenticated(OidcUser principal, List<String> productsToSearch) {
        if (Objects.isNull(principal)) {
            return;
        }
        UserEntity userEntity = userService.getByEmail(principal.getEmail()).orElseThrow(UserNotFoundException::new);
        save(new SearchHistoryEntity(LocalDateTime.now(), userEntity, productsToSearch));
    }

    public SearchHistoryEntity save(SearchHistoryEntity searchHistory) {
        return searchHistoryRepository.save(searchHistory);
    }

    public Collection<SearchHistoryEntity> getByUsersEmail(String email) {
        return searchHistoryRepository.findByUserEntity_Email(email);
    }
}
