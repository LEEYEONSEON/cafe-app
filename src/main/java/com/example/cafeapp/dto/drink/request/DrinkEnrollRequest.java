package com.example.cafeapp.dto.drink.request;

public class DrinkEnrollRequest {
    private String drinkName;
    private int price;

    public DrinkEnrollRequest(String drinkName, int price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getPrice() {
        return price;
    }
}
