package com.example.cafeapp.domain.customer.customerOrderHistory;

import com.example.cafeapp.domain.customer.Customer;
import jakarta.persistence.*;

@Entity
public class CustomerOrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;


    @Column(length = 25, name = "drink_name")
    private String drinkName;
    @Column(name = "pick_up")
    private boolean pickUp;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Customer customer;

    protected CustomerOrderHistory() {}

    public CustomerOrderHistory(String drinkName, Customer customer) {
        this.drinkName = drinkName;
        this.pickUp = false;
        this.customer = customer;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void pickUpDrink(){
        pickUp = true;
    }
}
