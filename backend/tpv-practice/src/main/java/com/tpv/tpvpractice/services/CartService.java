package com.tpv.tpvpractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpv.tpvpractice.models.Cart;
import com.tpv.tpvpractice.repositories.CartRepository;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public Cart getcartById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart addItem(Cart cart) {
        return cartRepository.save(cart);
    }
}