package com.io.io22.controller;

import com.io.io22.mapper.OfferMapper;
import com.io.io22.model.AddToCartModel;
import com.io.io22.service.CartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    public static final String SUCCESSFULLY_ADDED_OFFER = "Successfully added offer";
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String getCart(Model model,
                          @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("cartProducts", cartService.getUserCarts(principal));
        return "shopping-cart";
    }

    @PostMapping(path = "/add")
    public String addToCart(@AuthenticationPrincipal OidcUser principal,
                            AddToCartModel addToCartModel,
                            RedirectAttributes redirectAttributes) {
        cartService.addOfferToCart(OfferMapper.mapToOfferEntity(addToCartModel), principal.getEmail());
        redirectAttributes.addFlashAttribute("message", SUCCESSFULLY_ADDED_OFFER);
        return "redirect:/";


    }
}