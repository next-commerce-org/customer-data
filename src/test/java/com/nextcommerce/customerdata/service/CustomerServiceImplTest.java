package com.nextcommerce.customerdata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.nextcommerce.customerdata.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nextcommerce.customerdata.domain.Customer;

class CustomerServiceImplTest {


    // test method to verify that getCustomers() returns the expected list of customers

    private CustomerRepository customerRepository;
    private CustomerService customerService;
    private List<Customer> customers;


    @BeforeEach
    void setUp() {
        customers = new ArrayList<Customer>();
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
        customers.add(new Customer("john.dow@email.com",
                "John", "Dow", "1234567890"));
    }

    @Test
    void testGetCustomers() {
        when(customerRepository.findAll()).thenReturn(customers);
        assertEquals(customers, customerService.getCustomers());

    }
    @Test
    void testCreateCustomer() {
        Customer customer = new Customer("John.dow@mail.com","John","Dow","1234567890");
        when(customerRepository.save(customer)).thenReturn(customer);
        customerService.createCustomer(customer);
        verify(customerRepository, times(1)).save(customer);
    }
}