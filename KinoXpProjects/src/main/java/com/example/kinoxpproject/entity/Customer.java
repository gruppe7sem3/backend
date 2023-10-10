package com.example.kinoxpproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id") // Specify the column name for custId
    private int custId;

    @Column(name = "customer_name", unique = true) // Specify the column name for name
    private String name;

    @Column(name = "customer_password") // Specify the column name for name
    private String password;

    @Column(name = "customer_email") // Specify the column name for email
    private String email;

    @Column(name = "customer_phone") // Specify the column name for phone
    private String phone;

    @Column(name = "is_admin")
    private int isAdmin;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;


}
