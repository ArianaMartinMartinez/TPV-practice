package com.tpv.tpvpractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpv.tpvpractice.projections.BurgerProjection;
import com.tpv.tpvpractice.repositories.BurgerRepository;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository burgerRepository;

    public List<BurgerProjection> getBurgers() {
        return burgerRepository.findAllProjectedBy();
    }
}
