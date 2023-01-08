package com.io.io22.service;

import com.io.io22.entity.CartEntity;
import com.io.io22.entity.OfferEntity;
import com.io.io22.exception.UserNotFoundException;
import com.io.io22.repository.CartRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public void addOfferToCart(OfferEntity offer, String userEmail) {
        CartEntity userCart = getUserCart(userEmail).orElseThrow(UserNotFoundException::new);
        List<OfferEntity> offers = userCart.getOffers();
        offers.add(offer);
        userCart.setOffers(offers);
        save(userCart);
    }

    public CartEntity save(CartEntity cart) {
        return cartRepository.save(cart);
    }

    public CartEntity getUserCarts(OidcUser principal) {
        if (Objects.isNull(principal)) {
            throw new UserNotFoundException();
        }
        return getUserCart(principal.getEmail()).orElseThrow(UserNotFoundException::new);
    }

    private Optional<CartEntity> getUserCart(String email) {
        return cartRepository.findByUserEntity_Email(email);
    }
}
