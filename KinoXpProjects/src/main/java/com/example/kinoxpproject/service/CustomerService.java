package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer getCustomerById(int customerId) {
        return customerRepository.getCustomerById(customerId);
    }
}
