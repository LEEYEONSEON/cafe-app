package com.example.cafeapp.dto.drink.request;

public class DrinkDeleteRequest {
    private String drinkName;

    public DrinkDeleteRequest(String drinkName) {
        this.drinkName = drinkName;
    }

    public DrinkDeleteRequest() {}

    public String getDrinkName() {
        return drinkName;
    }
}
