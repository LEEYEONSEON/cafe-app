package com.example.cafeapp.dto.drink.request;

public class DrinkOrderRequest {
    private String customerName;
    private String drinkName;

    public DrinkOrderRequest(String customerName, String drinkName) {
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
