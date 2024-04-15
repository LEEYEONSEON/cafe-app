package com.example.cafeapp.controller.drink;

import com.example.cafeapp.dto.drink.request.*;
import com.example.cafeapp.dto.drink.response.DrinkResponse;
import com.example.cafeapp.service.drink.DrinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrinkController {
    //음료를 등록한다
    //음료목록을 보여준다
    //음료가격을 업데이트한다.
    //음료를 삭제한다


    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }


    @PostMapping("drink/enroll")
    public void enrollDrink(@RequestBody DrinkEnrollRequest request){
        drinkService.enrollDrink(request);
    }

    @GetMapping("drink/show")
    public List<DrinkResponse> showDrink(){
        return drinkService.showDrink();
    }

    @PutMapping("drink/update")
    public void updateDrink(@RequestBody DrinkUpdateRequest request){
        drinkService.updateDrink(request);
    }

    @DeleteMapping("drink/delete")
    public void deleteDrink(@RequestBody DrinkDeleteRequest request){
        drinkService.deleteDrink(request);
    }

    @PostMapping("drink/order")
    public void orderDrink(@RequestBody DrinkOrderRequest request){
        drinkService.orderDrink(request);
    }

    @PutMapping("drink/pickup")
    public void pickUpDrink(@RequestBody DrinkPickUpRequest request){
        drinkService.pickUpDrink(request);
    }


}
