package com.example.foodex;

public class ItemList {
    private String ItemName;
    private String ItemPrice;
    private String Make;

    public ItemList(String itemName, String itemPrice, String make) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        Make = make;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        this.Make = make;
    }
}
