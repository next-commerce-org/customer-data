package com.nextcommerce.customerdata.mapper;

import com.nextcommerce.customerdata.api.dto.CustomerDto;
import com.nextcommerce.customerdata.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements Mapper<CustomerDto, Customer> {
    @Override
    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getEmail(), customer.getFirstName(), customer.getLastName(), customer.getTelephone());
    }

    @Override
    public Customer toModel(CustomerDto customerDto) {
        return new Customer(customerDto.getEmail(), customerDto.getFirstName(), customerDto.getLastName(), customerDto.getTelephone());
    }

    @Override
    public Iterable<CustomerDto> toDtos(Iterable<Customer> customers) {
        List<CustomerDto> dtos = new ArrayList<>();
        customers.forEach(customer ->

                dtos.add(toDto(customer))
        );
        return dtos;

    }

    @Override
    public Iterable<Customer> toModels(Iterable<CustomerDto> d) {
        List<Customer> customers = new ArrayList<>();
        d.forEach(customerDto ->

                customers.add(toModel(customerDto))
        );
        return customers;
    }


}
