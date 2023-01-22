package com.io.io22.controller;

import com.io.io22.dto.AddToCartDTO;
import com.io.io22.entity.CartEntity;
import com.io.io22.entity.OfferEntity;
import com.io.io22.service.CartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String getCart(Model model,
                          @AuthenticationPrincipal OidcUser principal) {
        if (Objects.isNull(principal)) {
            return "shopping-cart";
        }
        List<OfferEntity> offers = cartService.getUserCart(principal.getEmail())
                .orElse(new CartEntity())
                .getOffers();
        model.addAttribute("cartOffers", offers);
        return "shopping-cart";
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId,
                              Model model,
                              @AuthenticationPrincipal OidcUser principal) {
        cartService.deleteProduct(productId, principal.getEmail());
    }

    @PostMapping(path = "/add")
    public void addToCart(@RequestBody AddToCartDTO addToCartDTO) {
        cartService.addOfferToCart(addToCartDTO);
    }
}
