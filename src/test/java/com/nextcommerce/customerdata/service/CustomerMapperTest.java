package com.nextcommerce.customerdata.service;

import com.nextcommerce.customerdata.api.dto.CustomerDto;
import com.nextcommerce.customerdata.domain.Customer;
import com.nextcommerce.customerdata.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CustomerMapperTest {

    private CustomerMapper customerMapper = new CustomerMapper();

    @Test
    void testToDto() {
        //generate new customer object
        Customer customer = new Customer("john.dow@email.com", "John",
                "Dow", "1234567890");
        CustomerDto customerDto = customerMapper.toDto(customer);
        //assert that the customerDto object has the same values as the customer object
        assert (customerDto.getEmail().equals(customer.getEmail()));
        assert (customerDto.getFirstName().equals(customer.getFirstName()));
        assert (customerDto.getLastName().equals(customer.getLastName()));
        assert (customerDto.getTelephone().equals(customer.getTelephone()));
    }

    @Test
    void testToModel() {
        //generate new customerDto object
        CustomerDto customerDto = new CustomerDto("john.dow@email.com",
                "John", "Dow", "1234567890");
        Customer customer = customerMapper.toModel(customerDto);
        //assert that the customer object has the same values as the customerDto object
        assert (customerDto.getEmail().equals(customer.getEmail()));
        assert (customerDto.getFirstName().equals(customer.getFirstName()));
        assert (customerDto.getLastName().equals(customer.getLastName()));
        assert (customerDto.getTelephone().equals(customer.getTelephone()));
    }

    @Test
    void testToDtos() {
        //generate new customer object
        Customer customer = new Customer("john.dow@email.com", "John",
                "Dow", "1234567890");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        Iterable<CustomerDto> customerDtos = customerMapper.toDtos(customers);
        //assert that the customerDto object has the same values as the customer object
        assert (customerDtos.iterator().next().getEmail().equals(customer.getEmail()));
        assert (customerDtos.iterator().next().getFirstName().equals(customer.getFirstName()));
        assert (customerDtos.iterator().next().getLastName().equals(customer.getLastName()));
        assert (customerDtos.iterator().next().getTelephone().equals(customer.getTelephone()));
    }

    @Test
    void testToModels() {
        //generate new customerDto object
        CustomerDto customerDto = new CustomerDto("john.dow@email.com",
                "John", "Dow", "1234567890");
        List<CustomerDto> customerDtos = new ArrayList<>();
        customerDtos.add(customerDto);
        Iterable<Customer> customers = customerMapper.toModels(customerDtos);
        //assert that the customer object has the same values as the customerDto object
        assert (customerDtos.get(0).getEmail().equals(customers.iterator().next().getEmail()));
        assert (customerDtos.get(0).getFirstName().equals(customers.iterator().next().getFirstName()));
        assert (customerDtos.get(0).getLastName().equals(customers.iterator().next().getLastName()));
        assert (customerDtos.get(0).getTelephone().equals(customers.iterator().next().getTelephone()));
    }

    @Test
    void testToModelsEmptyList() {
        //generate new customerDto object
        Iterable<CustomerDto> customerDtos = new ArrayList<>();
        Iterable<Customer> customers = customerMapper.toModels(customerDtos);
        //assert that the customer object has the same values as the customerDto object
        assert (!customers.iterator().hasNext());
    }

    @Test
    void testToDtosEmptyList() {
        //generate new customerDto object
        List<Customer> customers = new ArrayList<>();
        Iterable<CustomerDto> customerDtos = customerMapper.toDtos(customers);
        //assert that the customer object has the same values as the customerDto object
        assert (!customerDtos.iterator().hasNext());
    }
}
