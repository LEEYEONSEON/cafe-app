package com.example.cafeapp.dto.drink.request;

public class DrinkPickUpRequest {
    private String customerName;
    private String drinkName;

    public DrinkPickUpRequest(String customerName, String drinkName) {
        this.customerName = customerName;
        this.drinkName = drinkName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDrinkName() {
        return drinkName;
    }
}
