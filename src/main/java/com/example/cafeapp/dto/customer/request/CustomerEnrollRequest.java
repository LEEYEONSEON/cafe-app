package com.example.cafeapp.dto.customer.request;

public class CustomerEnrollRequest {
    private final String name;
    private final String nickname;

    public CustomerEnrollRequest(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
