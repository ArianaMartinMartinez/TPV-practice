package com.tpv.tpvpractice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpv.tpvpractice.models.Cart;
import com.tpv.tpvpractice.repositories.CartRepository;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public ArrayList<Cart> getCart() {
        return (ArrayList<Cart>) cartRepository.findAll();
    }
}
