package com.tpv.tpvpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpv.tpvpractice.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
