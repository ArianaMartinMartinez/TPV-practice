package com.tpv.tpvpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Burger;
import com.tpv.tpvpractice.models.Cart;
import com.tpv.tpvpractice.models.Drink;
import com.tpv.tpvpractice.requests.AddBurgerRequest;
import com.tpv.tpvpractice.requests.AddDrinkRequest;
import com.tpv.tpvpractice.services.BurgerService;
import com.tpv.tpvpractice.services.CartService;
import com.tpv.tpvpractice.services.DrinkService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    BurgerService burgerService;

    @Autowired
    DrinkService drinkService;

    @GetMapping()
    public List<Cart> getCart() {
        return cartService.getCart();
    }

    @PostMapping("/add/burger")
    public ResponseEntity<String> addBurgerToTheCart(@RequestBody AddBurgerRequest request) {
        Burger burger = burgerService.getBurgerById(request.getIdBurger());
        if(burger == null) {
            return ResponseEntity.badRequest().body("The burger does not exist");
        }

        Cart cart = new Cart();
        cart.setQuantity(request.getQuantity());
        cart.setSize(request.getSize());
        cart.setPrice(request.getPrice());
        cart.setIvaPrice(request.getIvaPrice());
        cart.setBurgers(burger);

        cartService.addItem(cart);

        return ResponseEntity.ok("Burger added to the cart");
    }

    @PostMapping("/add/drink")
    public ResponseEntity<String> addDrinkToTheCart(@RequestBody AddDrinkRequest request) {
        Drink drink = drinkService.getDrinkById(request.getIdDrink());
        if(drink == null) {
            return ResponseEntity.badRequest().body("The drink does not exist");
        }

        Cart cart = new Cart();
        cart.setQuantity(request.getQuantity());
        cart.setSize(request.getSize());
        cart.setPrice(request.getPrice());
        cart.setIvaPrice(request.getIvaPrice());
        cart.setDrinks(drink);

        cartService.addItem(cart);

        return ResponseEntity.ok("Drink added to the cart");
    }
}
