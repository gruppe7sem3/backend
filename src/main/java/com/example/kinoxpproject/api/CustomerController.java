package com.example.kinoxpproject.api;

import com.example.kinoxpproject.dto.BookingRequest;
import com.example.kinoxpproject.dto.CustomerRequest;
import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.service.BookingService;
import com.example.kinoxpproject.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody CustomerRequest customerRequest) {
        // Create the customer
        return customerService.addCustomer(customerRequest);

    }
}