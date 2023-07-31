package com.tpv.tpvpractice.requests;

public class AddBurgerRequest {
    private Integer quantity;
    private String size;
    private Double price;
    private Double ivaPrice;
    private Integer idBurger;
    
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
    
    public Integer getIdBurger() {
        return idBurger;
    }
    public void setIdBurger(Integer idBurger) {
        this.idBurger = idBurger;
    } 
}
