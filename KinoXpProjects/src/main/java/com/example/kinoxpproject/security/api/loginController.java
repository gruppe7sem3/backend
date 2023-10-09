package com.example.kinoxpproject.security.api;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.security.dto.LoginRequest;
import com.example.kinoxpproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/login")
public class loginController {


    @Autowired
    private CustomerService customerService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate the user based on email and password
        Customer customer = customerService.authLogin(loginRequest.getName(), loginRequest.getPassword());
        Integer custId = customerService.getCustIdByUsernameAndPassword( loginRequest.getPassword(),loginRequest.getName());

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // Authentication successful, you can generate a JWT token here and return it
        // ...
        return ResponseEntity.ok("" + custId);
    }
    }
