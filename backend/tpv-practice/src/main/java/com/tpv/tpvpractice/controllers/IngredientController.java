package com.tpv.tpvpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.projections.IngredientProjection;
import com.tpv.tpvpractice.services.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping()
    public List<IngredientProjection> getIngredients() {
        return ingredientService.getIngredients();
    }
}
