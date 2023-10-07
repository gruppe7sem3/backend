package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(int customerId) {
        return customerRepository.findById(customerId);
    }
}
