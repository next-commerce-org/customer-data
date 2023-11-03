package com.nextcommerce.customerdata.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;

import com.nextcommerce.customerdata.domain.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public List<Customer> getCustomers() {
         List<Customer> customers = new ArrayList<>();
        customers.add(new Customer( "johndoe@example.com","John", "Doe"));
        return customers;
       
    }

    @Override
    public void registerCustomer(Customer customer) {
        
        throw new UnsupportedOperationException("Unimplemented method 'registerCustomer'");
    }
    
}
