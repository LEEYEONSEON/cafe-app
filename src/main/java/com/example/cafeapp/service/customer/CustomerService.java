package com.example.cafeapp.service.customer;

import com.example.cafeapp.domain.customer.Customer;
import com.example.cafeapp.domain.customer.CustomerRepository;
import com.example.cafeapp.dto.customer.request.CustomerDeleteRequest;
import com.example.cafeapp.dto.customer.request.CustomerEnrollRequest;
import com.example.cafeapp.dto.customer.request.CustomerUpdateRequest;
import com.example.cafeapp.dto.customer.response.CustomerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void enrollCustomer(CustomerEnrollRequest request){
        customerRepository.save(new Customer(request.getName(), request.getNickname()));
    }
    @Transactional
    public List<CustomerResponse> showCustomer(){
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerResponse::new).collect(Collectors.toList());
    }
    @Transactional
    public void updateCustomer(CustomerUpdateRequest request){
        Customer customer = customerRepository.findByName(request.getName()).orElseThrow(IllegalArgumentException::new);
        customer.setNickname(request.getNickname());
    }
    @Transactional
    public void deleteCustomer(CustomerDeleteRequest request){
        Customer customer = customerRepository.findByIdAndName(request.getId(), request.getName()).orElseThrow(IllegalArgumentException::new);
        customerRepository.delete(customer);
    }
}
