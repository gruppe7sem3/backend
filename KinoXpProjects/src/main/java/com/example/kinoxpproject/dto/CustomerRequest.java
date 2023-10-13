package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Customer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    private String name;
    private String password;
    private String email;
    private int isAdmin;


    public Customer toCustomer() {
        return Customer.builder()
                .name(name)
                .password(password)
                .email(email)
                .isAdmin(isAdmin)
                .build();
    }
}