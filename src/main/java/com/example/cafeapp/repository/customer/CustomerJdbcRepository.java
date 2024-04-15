package com.example.cafeapp.repository.customer;


import com.example.cafeapp.dto.customer.request.CustomerDeleteRequest;
import com.example.cafeapp.dto.customer.request.CustomerEnrollRequest;
import com.example.cafeapp.dto.customer.request.CustomerUpdateRequest;
import com.example.cafeapp.dto.customer.response.CustomerResponse;

import java.util.List;

public interface CustomerJdbcRepository {
    public boolean isNotTargetExist(long id);

    public void enrollCustomer(CustomerEnrollRequest request);

    public List<CustomerResponse> showCustomer();

    public void updateCustomer(CustomerUpdateRequest request);

    public void deleteCustomer(CustomerDeleteRequest request);
}
