package com.nextcommerce.customerdata.service;

import com.nextcommerce.customerdata.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextcommerce.customerdata.domain.Customer;

/**
 * CustomerServiceImpl implements CustomerService interface.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
