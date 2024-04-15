package com.example.cafeapp.controller.customer;

import com.example.cafeapp.dto.customer.request.CustomerDeleteRequest;
import com.example.cafeapp.dto.customer.request.CustomerEnrollRequest;
import com.example.cafeapp.dto.customer.request.CustomerUpdateRequest;
import com.example.cafeapp.dto.customer.response.CustomerResponse;
//import com.example.cafeapp.service.customer.CustomerJdbcService;
import com.example.cafeapp.service.customer.CustomerService;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//api 진입지점으로 만들어줌
@RestController
public class CustomerController {
    //mysql 데이터베이스에 jdbctemplate이 연결해주어 메모리대신 데이터베이스에 정보 저장
    //public final JdbcTemplate jdbcTemplate;
    private final CustomerService customerService;
//    public final CustomerJdbcService customerService;

    public CustomerController(CustomerService customerService) {
        //this.jdbcTemplate = jdbcTemplate;
        this.customerService = customerService;
    }

//    ArrayList<Customer> customerList = new ArrayList<>();

    //고객정보 등록
    @PostMapping("/customer/enroll")
    public void enrollCustomer(@RequestBody CustomerEnrollRequest request) {
        customerService.enrollCustomer(request);
    }

    //고객정보 조회
    @GetMapping("/customer/show")
    public List<CustomerResponse> showCustomer() {
        return customerService.showCustomer();
    }

    //고객정보 수정
    @PutMapping("/customer/update")
    public void updateCustomer(@RequestBody CustomerUpdateRequest request) {
        customerService.updateCustomer(request);
    }

    //고객정보 삭제
    @DeleteMapping("/customer/delete")
    public void deleteCustomer(@RequestBody CustomerDeleteRequest request) {
        customerService.deleteCustomer(request);
    }

}
