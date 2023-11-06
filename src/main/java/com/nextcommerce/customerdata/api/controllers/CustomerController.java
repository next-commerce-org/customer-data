package com.nextcommerce.customerdata.api.controllers;

import com.nextcommerce.customerdata.api.dto.CustomerDto;
import com.nextcommerce.customerdata.domain.Customer;
import com.nextcommerce.customerdata.mapper.CustomerMapper;
import com.nextcommerce.customerdata.mapper.Mapper;
import com.nextcommerce.customerdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Mapper<CustomerDto, Customer> customerMapper;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        return ResponseEntity.ok(customerMapper.toDtos(customerService.getCustomers()));
    }

}