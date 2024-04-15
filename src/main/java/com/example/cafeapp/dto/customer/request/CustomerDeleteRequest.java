package com.example.cafeapp.dto.customer.request;

public class CustomerDeleteRequest {
    private long id;
    private String name;

    public CustomerDeleteRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
