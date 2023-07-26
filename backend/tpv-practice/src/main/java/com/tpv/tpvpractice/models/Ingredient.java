package com.tpv.tpvpractice.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Burger> burgers;

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

    public List<Burger> getBurgers() {
        return burgers;
    }
    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }
}
