package com.nextcommerce.customerdata.domain;

import javax.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
 
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String telephone;
      public Customer(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
       
    }
}
