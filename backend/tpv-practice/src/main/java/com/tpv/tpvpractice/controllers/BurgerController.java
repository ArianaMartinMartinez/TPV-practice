package com.tpv.tpvpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Burger;
import com.tpv.tpvpractice.services.BurgerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/burgers")
public class BurgerController {
    @Autowired
    BurgerService burgerService;

    @GetMapping()
    public List<Burger> getBurgers() {
        return burgerService.getBurgers();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Integer id) {
        return burgerService.getBurgerById(id);
    }
}
