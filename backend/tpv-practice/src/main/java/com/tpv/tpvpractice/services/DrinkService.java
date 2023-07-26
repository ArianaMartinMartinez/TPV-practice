package com.tpv.tpvpractice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpv.tpvpractice.models.Drink;
import com.tpv.tpvpractice.repositories.DrinkRepository;

@Service
public class DrinkService {
    @Autowired
    DrinkRepository drinkRepository;

    public ArrayList<Drink> getDrinks() {
        return (ArrayList<Drink>) drinkRepository.findAll();
    }
}
