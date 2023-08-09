package com.tpv.tpvpractice.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Drink;
import com.tpv.tpvpractice.services.DrinkService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/drinks")
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @GetMapping()
    public ArrayList<Drink> getDrinks() {
        return drinkService.getDrinks();
    }
}
