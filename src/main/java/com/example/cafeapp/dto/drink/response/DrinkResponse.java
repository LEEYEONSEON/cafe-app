package com.example.cafeapp.dto.drink.response;

import com.example.cafeapp.domain.drink.Drink;

public class DrinkResponse {
    private Long id;
    private String drinkName;
    private int price;

    public DrinkResponse(Drink drink) {
        this.id = drink.getId();
        this.drinkName = drink.getDrinkName();
        this.price = drink.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getPrice() {
        return price;
    }
}
