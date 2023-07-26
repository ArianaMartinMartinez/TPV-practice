package com.tpv.tpvpractice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tpv.tpvpractice.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    
}
