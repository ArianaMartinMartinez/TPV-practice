package com.tpv.tpvpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpv.tpvpractice.models.Burger;

public interface BurgerRepository extends JpaRepository<Burger, Integer> {
}
