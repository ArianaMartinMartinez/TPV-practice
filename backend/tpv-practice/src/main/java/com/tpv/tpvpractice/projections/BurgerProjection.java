package com.tpv.tpvpractice.projections;

import java.util.List;

public interface BurgerProjection {
    Integer getId();
    String getName();
    Double getPrice();
    String getPhoto();
    List<IngredientProjection> getIngredients();
}
