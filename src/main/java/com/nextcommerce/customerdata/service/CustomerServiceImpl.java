package com.nextcommerce.customerdata.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nextcommerce.customerdata.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("johndoe@example.com", "John", "Doe", "1234567890"));
        return customers;

    }

}
