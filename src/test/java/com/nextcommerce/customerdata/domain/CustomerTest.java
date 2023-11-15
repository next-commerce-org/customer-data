package com.nextcommerce.customerdata.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

    @Test
    void testCustomer() {
        Customer customer = new Customer();
        //assert customer not null
        assertNotNull(customer);
    }
}