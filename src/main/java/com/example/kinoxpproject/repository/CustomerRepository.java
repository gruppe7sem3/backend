package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByNameAndPassword(String name, String password);
    @Query("SELECT custId FROM Customer WHERE name = :name AND password = :password")
    Integer getCustIdByNameAndPassword(String password, String name);

}
