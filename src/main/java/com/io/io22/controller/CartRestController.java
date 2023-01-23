package com.io.io22.controller;

import com.io.io22.dto.AddToCartDTO;
import com.io.io22.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cart")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(path = "/add")
    public void addToCart(@RequestBody AddToCartDTO addToCartDTO) {
        cartService.addOfferToCart(addToCartDTO);
    }
}
