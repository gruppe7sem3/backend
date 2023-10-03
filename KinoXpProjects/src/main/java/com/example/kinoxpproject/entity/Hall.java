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
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_id") // Specify the column name for hallId
    private int hallId;

    @Column(name = "hall_name") // Specify the column name for hallName
    private String hallName;

    @Column(name = "capacity") // Specify the column name for capacity
    private int capacity;

    @Column(name = "layout") // Specify the column name for layout
    private String layout;

    @OneToMany(mappedBy = "hall")
    private List<Shows> shows;

    @OneToMany(mappedBy = "hall")
    private List<Seat> seats;
}
