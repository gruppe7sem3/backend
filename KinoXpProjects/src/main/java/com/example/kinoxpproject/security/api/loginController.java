package com.example.kinoxpproject.security.api;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.security.dto.LoginRequest;
import com.example.kinoxpproject.security.dto.LoginResponse;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate the user based on email and password
        Customer customer = customerService.authLogin(loginRequest.getName(), loginRequest.getPassword());
        Integer custId = customerService.getCustIdByUsernameAndPassword(loginRequest.getPassword(), loginRequest.getName());
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        Integer valueId = customer.getIsAdmin();

        // Create a LoginResponse object that includes both custId and value
        LoginResponse loginResponse = new LoginResponse(custId, valueId);

        // Return the LoginResponse in a single ResponseEntity
        return ResponseEntity.ok(loginResponse);
    }

}
