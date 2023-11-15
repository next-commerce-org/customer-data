package com.nextcommerce.customerdata.service;


import com.nextcommerce.customerdata.domain.Customer;


public interface CustomerService {
    public Iterable<Customer> getCustomers();

    void createCustomer(Customer customer);
}
