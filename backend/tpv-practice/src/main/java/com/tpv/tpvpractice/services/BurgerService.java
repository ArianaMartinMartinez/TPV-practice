package com.tpv.tpvpractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpv.tpvpractice.models.Burger;
import com.tpv.tpvpractice.repositories.BurgerRepository;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository burgerRepository;

    public List<Burger> getBurgers() {
        return burgerRepository.findAll();
    }

    public Burger getBurgerById(Integer id) {
        return burgerRepository.findById(id).orElse(null);
    }
}
