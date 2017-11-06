package com.matthew.checkout.checkoutconsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    
    private String itemId;
    private double quantity;
    private double totalPrice;
    
    public Item() {
    }
    
    public Item(String itemId, double quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice;
    }
    
}
