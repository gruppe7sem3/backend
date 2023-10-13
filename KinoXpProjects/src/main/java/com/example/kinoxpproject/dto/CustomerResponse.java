package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

    private int custId;
    private String name;
    private int isAdmin;

    private String password;
    private String email;
    private String phone;


    // Constructor to create a response from a Customer entity
    public CustomerResponse(Customer customer) {
        this.custId = customer.getCustId();
        this.name = customer.getName();
        this.password = customer.getPassword();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.isAdmin = customer.getIsAdmin();
    }
}