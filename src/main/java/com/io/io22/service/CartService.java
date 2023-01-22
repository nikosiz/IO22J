package com.io.io22.service;

import com.io.io22.dto.AddToCartDTO;
import com.io.io22.entity.CartEntity;
import com.io.io22.entity.OfferEntity;
import com.io.io22.entity.UserEntity;
import com.io.io22.exception.UserNotFoundException;
import com.io.io22.mapper.OfferMapper;
import com.io.io22.repository.CartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final UserService userService;

    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Transactional
    public void addOfferToCart(AddToCartDTO addToCartDTO) {
        UserEntity userEntity = userService.getByEmail(addToCartDTO.getUserEmail()).orElseThrow(UserNotFoundException::new);
        CartEntity userCart = getUserCart(addToCartDTO.getUserEmail()).orElse(new CartEntity(userEntity));
        List<OfferEntity> offers = userCart.getOffers();
        if (isProductAlreadyInCart(addToCartDTO, offers)) {
            return;
        }
        offers.add(OfferMapper.toOfferEntity(addToCartDTO));
        userCart.setOffers(offers);
        save(userCart);
    }

    private boolean isProductAlreadyInCart(AddToCartDTO addToCartDTO, List<OfferEntity> offers) {
        return offers.stream()
                .anyMatch(s -> s.getName().equals(addToCartDTO.getName()));
    }

    public CartEntity save(CartEntity cart) {
        return cartRepository.save(cart);
    }

    public Optional<CartEntity> getUserCart(String email) {
        return cartRepository.findByUserEntity_Email(email);
    }
}
