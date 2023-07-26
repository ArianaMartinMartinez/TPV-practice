package com.tpv.tpvpractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpv.tpvpractice.projections.IngredientProjection;
import com.tpv.tpvpractice.repositories.IngredientRepository;

@Service
public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    public List<IngredientProjection> getIngredients() {
        return ingredientRepository.findAllProjectedBy();
    }
}
