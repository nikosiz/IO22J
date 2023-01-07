package com.io.io22.service;

import com.io.io22.entity.CartEntity;
import com.io.io22.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<CartEntity> getUserCart(String email) {
        return cartRepository.findByUserEntity_Email(email);
    }
}
