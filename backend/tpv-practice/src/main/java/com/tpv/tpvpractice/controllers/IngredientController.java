package com.tpv.tpvpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Ingredient;
import com.tpv.tpvpractice.services.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<Ingredient> getIngredients() {
        return ingredientService.getIngredients();
    }
}
