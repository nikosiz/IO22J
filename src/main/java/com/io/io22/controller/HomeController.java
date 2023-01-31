package com.io.io22.controller;

import com.io.io22.ceneo.service.CeneoService;
import com.io.io22.model.ProductSearchModel;
import com.io.io22.service.SearchHistoryService;
import com.io.io22.utils.SortEnum;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class HomeController {

    private final CeneoService ceneoService;

    private final SearchHistoryService searchHistoryService;

    public HomeController(CeneoService ceneoService, SearchHistoryService searchHistoryService) {
        this.ceneoService = ceneoService;
        this.searchHistoryService = searchHistoryService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("productsToSearch", new ProductSearchModel());
        return "index";
    }

    @GetMapping("/searchProduct")
    public String getProducts(@RequestParam(name = "sorting") Optional<SortEnum> sorting,
                              ProductSearchModel productSearchModel,
                              @AuthenticationPrincipal OidcUser principal,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors() || Objects.isNull(productSearchModel)) {
            return "index";
        }
        if (!Objects.isNull(principal)) {
            model.addAttribute("userEmail", principal.getEmail());
        }
        List<String> productsToSearch = productSearchModel.getProductsToSearch();
        productsToSearch.removeAll(Collections.singleton(""));
        model.addAttribute("products", ceneoService.getCeneoProducts(productsToSearch, sorting));
        searchHistoryService.addIfUserAuthenticated(principal, productsToSearch);
        return "index";
    }

}
