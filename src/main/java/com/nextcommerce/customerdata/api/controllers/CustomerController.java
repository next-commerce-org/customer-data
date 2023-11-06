package com.nextcommerce.customerdata.api.controllers;

import com.nextcommerce.customerdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

}