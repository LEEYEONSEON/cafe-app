package com.example.cafeapp.domain.customer;

import com.example.cafeapp.domain.customer.customerOrderHistory.CustomerOrderHistory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(length = 25, name = "name")
    private String name;
    @Column(length = 25, name = "nick_name")
    private String nickname;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CustomerOrderHistory> histories = new ArrayList<>();
    public Customer(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    protected Customer() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void orderDrink(String drinkName){
        histories.add(new CustomerOrderHistory(drinkName, this ));
    }
    public void pickUpDrink(String drinkName){
        CustomerOrderHistory history = histories.stream().filter(target -> target.getDrinkName().equals(drinkName)).findFirst().
                orElseThrow(IllegalArgumentException::new);
        history.pickUpDrink();
    }
}
