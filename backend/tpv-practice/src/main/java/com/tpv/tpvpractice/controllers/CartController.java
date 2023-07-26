package com.tpv.tpvpractice.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Cart;
import com.tpv.tpvpractice.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping()
    public ArrayList<Cart> getCart() {
        return cartService.getCart();
    }
}
