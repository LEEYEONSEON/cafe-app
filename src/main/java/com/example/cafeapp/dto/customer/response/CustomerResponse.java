package com.example.cafeapp.dto.customer.response;

import com.example.cafeapp.domain.customer.Customer;

public class CustomerResponse {
    private long id;
    private String name;
    private String nickname;

    public CustomerResponse(long id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }
    public CustomerResponse(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.nickname = customer.getNickname();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
