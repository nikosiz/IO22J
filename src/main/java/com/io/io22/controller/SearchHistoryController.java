package com.io.io22.controller;

import com.io.io22.service.SearchHistoryService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/history")
public class SearchHistoryController {

    private final SearchHistoryService historyService;

    public SearchHistoryController(SearchHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public String getSearchHistory(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("searchHistory", historyService.getByUsersEmail(principal.getEmail()));
        return "search-history";
    }
}
