package com.io.io22.controller;

import com.io.io22.service.CartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public String getCart(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("cartProducts", cartService.getUserCart(principal.getEmail()));
        return "shopping-cart";
    }
}
