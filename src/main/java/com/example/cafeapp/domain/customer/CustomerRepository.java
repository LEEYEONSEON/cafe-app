package com.example.cafeapp.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findByName(String name);
    public Optional<Customer> findByIdAndName(long id, String name);
}
