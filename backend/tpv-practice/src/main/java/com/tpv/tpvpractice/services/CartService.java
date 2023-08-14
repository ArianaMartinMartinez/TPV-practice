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

    //GET
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    //POST
    public Cart addItem(Cart cart) {
        return cartRepository.save(cart);
    }

    //PUT
    public void moreQuantity(Cart cart) {
        Double total = Math.floor(((cart.getQuantity()+1) * cart.getIvaPrice()) * 100) / 100;
        cart.setQuantity(cart.getQuantity() + 1);
        cart.setTotal(total);
        cartRepository.save(cart);
    }

    public void lessQuantity(Cart cart) {
        Double total = Math.floor(((cart.getQuantity()-1) * cart.getIvaPrice()) * 100) / 100;
        cart.setQuantity(cart.getQuantity() - 1);
        cart.setTotal(total);
        cartRepository.save(cart);
    }

    //DELETE
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }

    public void deleteAll() {
        cartRepository.deleteAll();
    }
}
