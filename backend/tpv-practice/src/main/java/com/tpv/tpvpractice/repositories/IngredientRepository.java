package com.tpv.tpvpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpv.tpvpractice.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}