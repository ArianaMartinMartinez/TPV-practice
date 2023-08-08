package com.tpv.tpvpractice.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Drink;
import com.tpv.tpvpractice.services.DrinkService;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ArrayList<Drink> getDrinks() {
        return drinkService.getDrinks();
    }
}
