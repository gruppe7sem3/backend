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
    private String email;
    public Customer toCustomer() {
        return Customer.builder()
                .name(name)
                .email(email)
                .build();
    }
}