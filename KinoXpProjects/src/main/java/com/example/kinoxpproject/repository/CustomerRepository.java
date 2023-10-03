package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
