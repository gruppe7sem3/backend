package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer getCustomerById(int customerId);
}
