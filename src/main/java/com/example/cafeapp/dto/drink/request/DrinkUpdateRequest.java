package com.example.cafeapp.dto.drink.request;

public class DrinkUpdateRequest {
    private String drinkName;
    private int price;

    public DrinkUpdateRequest(String drinkName, int price) {
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
