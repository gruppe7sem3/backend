package com.example.kinoxpproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id") // Specify the column name for custId
    private int custId;

    @Column(name = "customer_name") // Specify the column name for name
    private String name;

    @Column(name = "customer_email") // Specify the column name for email
    private String email;

    @Column(name = "customer_phone") // Specify the column name for phone
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;
}
