package com.io.io22.controller;

import com.io.io22.ceneo.service.CeneoService;
import com.io.io22.model.ProductSearchModel;
import com.io.io22.utils.SortEnum;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

@Controller
public class HomeController {

    private final CeneoService ceneoService;

    public HomeController(CeneoService ceneoService) {
        this.ceneoService = ceneoService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("productsToSearch", new ProductSearchModel());
        return "index";
    }

    @GetMapping("/searchProduct")
    public String getProducts(@RequestParam(name = "sorting") Optional<SortEnum> sorting,
                              ProductSearchModel productSearchModel,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors() || Objects.isNull(productSearchModel)) {
            return "index";
        }
        model.addAttribute("products", ceneoService.getCeneoProducts(productSearchModel.getProductsToSearch(), sorting));
        return "index";
    }

}
