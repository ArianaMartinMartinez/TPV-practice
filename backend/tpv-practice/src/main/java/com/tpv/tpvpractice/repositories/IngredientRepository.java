package com.tpv.tpvpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpv.tpvpractice.models.Ingredient;
import com.tpv.tpvpractice.projections.IngredientProjection;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<IngredientProjection> findAllProjectedBy();
}