package com.example.kinoxpproject.api;

import com.example.kinoxpproject.service.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin")

public class AdminController {

    private final CustomerService customerService;


    public AdminController(CustomerService customerService) {
        this.customerService = customerService;
    }




}
