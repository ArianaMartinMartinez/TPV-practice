package com.tpv.tpvpractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private Double price;

    @Column(name = "iva_price")
    private Double ivaPrice;

    @OneToOne
    @JoinColumn(name = "id_burger")
    private Burger burgers;

    @OneToOne
    @JoinColumn(name = "id_drink")
    private Drink drinks;

    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getIvaPrice() {
        return ivaPrice;
    }
    public void setIvaPrice(Double ivaPrice) {
        this.ivaPrice = ivaPrice;
    }

    public Burger getBurgers() {
        return burgers;
    }
    public void setBurgers(Burger burgers) {
        this.burgers = burgers;
    }

    public Drink getDrinks() {
        return drinks;
    }
    public void setDrinks(Drink drinks) {
        this.drinks = drinks;
    }
}
