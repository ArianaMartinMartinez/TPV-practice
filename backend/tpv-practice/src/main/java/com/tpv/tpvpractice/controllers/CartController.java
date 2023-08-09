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
import com.tpv.tpvpractice.requests.ModifyItemRequest;
import com.tpv.tpvpractice.services.BurgerService;
import com.tpv.tpvpractice.services.CartService;
import com.tpv.tpvpractice.services.DrinkService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

        Double total = request.getIvaPrice() * request.getQuantity();
        Cart cart = new Cart();
        cart.setQuantity(request.getQuantity());
        cart.setSize(request.getSize());
        cart.setPrice(request.getPrice());
        cart.setIvaPrice(request.getIvaPrice());
        cart.setTotal(total);
        cart.setBurger(burger);

        cartService.addItem(cart);

        return ResponseEntity.ok("Burger added to the cart");
    }

    @PostMapping("/add/drink")
    public ResponseEntity<String> addDrinkToTheCart(@RequestBody AddDrinkRequest request) {
        Drink drink = drinkService.getDrinkById(request.getIdDrink());
        if(drink == null) {
            return ResponseEntity.badRequest().body("The drink does not exist");
        }

        Double total = request.getIvaPrice() * request.getQuantity();
        Cart cart = new Cart();
        cart.setQuantity(request.getQuantity());
        cart.setSize(request.getSize());
        cart.setPrice(request.getPrice());
        cart.setIvaPrice(request.getIvaPrice());
        cart.setTotal(total);
        cart.setDrink(drink);

        cartService.addItem(cart);

        return ResponseEntity.ok("Drink added to the cart");
    }

    @PutMapping("/moreQuantity")
    public void moreQuantity(@RequestBody ModifyItemRequest request) {
        Cart cart = cartService.getCartById(request.getIdCart());
        cartService.moreQuantity(cart);
    }

    @PutMapping("/lessQuantity")
    public void lessQuantity(@RequestBody ModifyItemRequest request) {
        Cart cart = cartService.getCartById(request.getIdCart());
        cartService.lessQuantity(cart);
    }
}
