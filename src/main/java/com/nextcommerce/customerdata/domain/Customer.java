package com.nextcommerce.customerdata.domain;

import javax.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Customer {

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String telephone;

}
