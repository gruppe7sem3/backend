package com.example.kinoxpproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id") // Specify the column name for bookingId
    private int bookingId;


    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Shows shows;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booking_timestamp") // Specify the column name for timestamp
    private Date timestamp;

    @Column(name = "total_amount") // Specify the column name for totalAmount
    private double totalAmount;
}
