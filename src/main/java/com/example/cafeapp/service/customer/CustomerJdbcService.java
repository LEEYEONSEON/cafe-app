
package com.example.cafeapp.service.customer;

import com.example.cafeapp.dto.customer.request.CustomerDeleteRequest;
import com.example.cafeapp.dto.customer.request.CustomerEnrollRequest;
import com.example.cafeapp.dto.customer.request.CustomerUpdateRequest;
import com.example.cafeapp.dto.customer.response.CustomerResponse;
import com.example.cafeapp.repository.customer.CustomerJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerJdbcService {
    public final CustomerJdbcRepository customerRepository;

    public CustomerJdbcService(CustomerJdbcRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void enrollCustomer(CustomerEnrollRequest request) {
        customerRepository.enrollCustomer(request);
    }

    public List<CustomerResponse> showCustomer() {
        return customerRepository.showCustomer();
    }

    public void updateCustomer(CustomerUpdateRequest request) {
        if (customerRepository.isNotTargetExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        customerRepository.updateCustomer(request);
    }

    public void deleteCustomer(CustomerDeleteRequest request) {
        if (customerRepository.isNotTargetExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        customerRepository.deleteCustomer(request);
    }
}
