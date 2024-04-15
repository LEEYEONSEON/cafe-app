package com.example.cafeapp.service.drink;

import com.example.cafeapp.domain.customer.Customer;
import com.example.cafeapp.domain.customer.CustomerRepository;
import com.example.cafeapp.domain.drink.Drink;
import com.example.cafeapp.domain.drink.DrinkRepository;
import com.example.cafeapp.dto.drink.request.*;
import com.example.cafeapp.dto.drink.response.DrinkResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final CustomerRepository customerRepository;

    public DrinkService(DrinkRepository drinkRepository, CustomerRepository customerRepository) {
        this.drinkRepository = drinkRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void enrollDrink(DrinkEnrollRequest request) {
        drinkRepository.save(new Drink(request.getDrinkName(), request.getPrice()));
    }

    @Transactional
    public List<DrinkResponse> showDrink() {
        return drinkRepository.findAll().stream().map(DrinkResponse::new).collect(Collectors.toList());
    }

    //이름과 가격을 받아, 가격을 변경한다.
    @Transactional
    public void updateDrink(DrinkUpdateRequest request) {
        Drink drink = drinkRepository.findByDrinkName(request.getDrinkName()).orElseThrow(IllegalArgumentException::new);
        drink.setPrice(request.getPrice());
    }

    //음료 이름을 받아 지운다.
    @Transactional
    public void deleteDrink(DrinkDeleteRequest request) {
        Drink drink = drinkRepository.findByDrinkName(request.getDrinkName()).orElseThrow(IllegalArgumentException::new);
        drinkRepository.delete(drink);
    }

    //request의 사용자이름과 음료이름을 받아와, 사용자 id를 찾아 customerorderhistory에 기록해준다.
    @Transactional
    public void orderDrink(DrinkOrderRequest request) {
        Customer customer = customerRepository.findByName(request.getCustomerName()).orElseThrow(IllegalArgumentException::new);
        customer.orderDrink(request.getDrinkName());
    }

    @Transactional
    public void pickUpDrink(DrinkPickUpRequest request) {
        Customer customer = customerRepository.findByName(request.getCustomerName()).orElseThrow(IllegalArgumentException::new);
        customer.pickUpDrink(request.getDrinkName());
    }

}
