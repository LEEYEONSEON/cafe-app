package com.example.cafeapp.dto.customer.request;

public class CustomerUpdateRequest {
    private long id;
    private String name;
    private String nickname;

    public CustomerUpdateRequest(long id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }
}
