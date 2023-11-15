package com.nextcommerce.customerdata.api.controllers;


import com.nextcommerce.customerdata.api.dto.CustomerDto;
import com.nextcommerce.customerdata.domain.Customer;
import com.nextcommerce.customerdata.mapper.Mapper;
import com.nextcommerce.customerdata.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @MockBean
    private CustomerService customerService;
    @MockBean
    private Mapper<CustomerDto, Customer> mapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CustomerController customerController;

    @Test
    void testCustomerController() {
        assert (customerController != null);
    }

    @Test
    void testCustomerEmpty() throws Exception {
        when(customerService.getCustomers()).thenReturn(new ArrayList<>());
        when(mapper.toDtos(new ArrayList<>())).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/customers")).andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testCustomerNotEmpty() throws Exception {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("john.dow@email.com",
                "John", "Dow", "1234567890"));
        when(customerService.getCustomers()).thenReturn(customers);
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        customerDtos.add(new CustomerDto("john.dow@email.com",
                "John", "Dow", "1234567890"));
        when(mapper.toDtos(customers)).thenReturn(customerDtos);
        mockMvc.perform(get("/customers")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email", is("john.dow@email.com")))
                .andExpect(jsonPath("$[0].firstName", is("John")))
                .andExpect(jsonPath("$[0].lastName", is("Dow")))
                .andExpect(jsonPath("$[0].telephone", is("1234567890")));
    }

    @Test
    public void testCustomerPost() throws Exception {
        CustomerDto customerDto = new CustomerDto("hohn.dow@email.com",
                "Hohn", "Dow", "1234567890");
        Customer customer = new Customer(customerDto.getEmail(), customerDto.getFirstName(), customerDto.getLastName(), customerDto.getTelephone());
        when(mapper.toModel(customerDto)).thenReturn(customer);
        mockMvc.perform(post("/customer")).andExpect(status().isOk());

    }


}
