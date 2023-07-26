package com.tpv.tpvpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpv.tpvpractice.models.Burger;
import com.tpv.tpvpractice.projections.BurgerProjection;

public interface BurgerRepository extends JpaRepository<Burger, Integer> {
    List<BurgerProjection> findAllProjectedBy();
}
