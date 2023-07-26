package com.tpv.tpvpractice.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "burger")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "photo")
    private String photo;

    @ManyToMany
    @JoinTable(
        name = "burger_ingredient",
        joinColumns = @JoinColumn(name = "id_burger"),
        inverseJoinColumns = @JoinColumn(name = "id_ingredient")
    )
    private List<Ingredient> ingredients;

    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    } 
}
