package com.example.cafeapp.domain.drink;

import jakarta.persistence.*;

@Entity
public class Drink {
    //음료를 내준다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id= null;
    @Column(length = 25, name = "drink_name")
    private String drinkName;
    @Column(name = "price")
    private int price;

    protected Drink() {}

    public Drink(String drinkName, int price) {
        this.drinkName = drinkName;
        this.price = price;
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

    public void setPrice(int price) {
        this.price = price;
    }
}
