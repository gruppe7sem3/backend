package com.example.kinoxpproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id") // Specify the column name for seatId
    private int seatId;

    @Column(name = "seat_number") // Specify the column name for seatNum
    private String seatNum;

    @Column(name = "seat_row") // Specify the column name for row
    private String row;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @Column(name = "is_booked") // Specify the column name for isBooked
    private boolean isBooked;
}
