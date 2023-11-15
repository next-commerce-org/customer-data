package com.nextcommerce.customerdata.api.controllers;

import com.nextcommerce.customerdata.api.dto.CustomerDto;
import com.nextcommerce.customerdata.domain.Customer;
import com.nextcommerce.customerdata.mapper.Mapper;
import com.nextcommerce.customerdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final Mapper<CustomerDto,Customer> customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, Mapper<CustomerDto, Customer> customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/customers")
    public ResponseEntity<Iterable<CustomerDto>> getCustomers() {
        return ResponseEntity.ok(customerMapper.toDtos(customerService.getCustomers()));
    }

}