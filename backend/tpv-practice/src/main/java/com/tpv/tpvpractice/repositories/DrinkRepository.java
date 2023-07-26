package com.tpv.tpvpractice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tpv.tpvpractice.models.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Integer> {
    
}
