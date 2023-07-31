package com.tpv.tpvpractice.requests;

public class AddDrinkRequest {
    private Integer quantity;
    private String size;
    private Double price;
    private Double ivaPrice;
    private Integer idDrink;

    //GETTERS AND SETTERS
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

    public Integer getIdDrink() {
        return idDrink;
    }
    public void setIdDrink(Integer idDrink) {
        this.idDrink = idDrink;
    }   
}