package com.tpv.tpvpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpv.tpvpractice.models.Burger;
import com.tpv.tpvpractice.services.BurgerService;

@RestController
@RequestMapping("/burgers")
public class BurgerController {
    @Autowired
    BurgerService burgerService;

    @GetMapping()
    public List<Burger> getBurgers() {
        return burgerService.getBurgers();
    }
}