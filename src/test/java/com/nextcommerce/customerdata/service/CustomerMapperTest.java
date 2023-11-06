package com.nextcommerce.customerdata.service;

import com.nextcommerce.customerdata.api.dto.CustomerDto;
import com.nextcommerce.customerdata.domain.Customer;
import com.nextcommerce.customerdata.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapperTest {

    private CustomerMapper customerMapper = new CustomerMapper();

    @Test
    public void testToDto() {
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
    public void testToModel() {
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
    public void testToDtos() {
        //generate new customer object
        Customer customer = new Customer("john.dow@email.com", "John",
                "Dow", "1234567890");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        List<CustomerDto> customerDtos = customerMapper.toDtos(customers);
        //assert that the customerDto object has the same values as the customer object
        assert (customerDtos.get(0).getEmail().equals(customer.getEmail()));
        assert (customerDtos.get(0).getFirstName().equals(customer.getFirstName()));
        assert (customerDtos.get(0).getLastName().equals(customer.getLastName()));
        assert (customerDtos.get(0).getTelephone().equals(customer.getTelephone()));
    }

    @Test
    public void testToModels() {
        //generate new customerDto object
        CustomerDto customerDto = new CustomerDto("john.dow@email.com",
                "John", "Dow", "1234567890");
        List<CustomerDto> customerDtos = new ArrayList<>();
        customerDtos.add(customerDto);
        List<Customer> customers = customerMapper.toModels(customerDtos);
        //assert that the customer object has the same values as the customerDto object
        assert (customerDtos.get(0).getEmail().equals(customers.get(0).getEmail()));
        assert (customerDtos.get(0).getFirstName().equals(customers.get(0).getFirstName()));
        assert (customerDtos.get(0).getLastName().equals(customers.get(0).getLastName()));
        assert (customerDtos.get(0).getTelephone().equals(customers.get(0).getTelephone()));
    }
    @Test
    public void testToModelsEmptyList() {
        //generate new customerDto object
        List<CustomerDto> customerDtos = new ArrayList<>();
        List<Customer> customers = customerMapper.toModels(customerDtos);
        //assert that the customer object has the same values as the customerDto object
        assert (customers.size() == 0);
    }
    @Test
    public void testToDtosEmptyList() {
        //generate new customerDto object
        List<Customer> customers = new ArrayList<>();
        List<CustomerDto> customerDtos = customerMapper.toDtos(customers);
        //assert that the customer object has the same values as the customerDto object
        assert (customerDtos.size() == 0);
    }
}
