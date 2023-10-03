package com.example.kinoxpproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id") // Specify the column name for showId
    private int showId;

    @ManyToOne
    @JoinColumn(name = "movie_id") // Specify the column name for movieId
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "hall_id" ) // Specify the column name for hallId
    private Hall hall;

    @Column(name = "show_date") // Specify the column name for showDate
    private LocalDate showDate;

    @Column(name = "show_time") // Specify the column name for showTime
    private LocalDateTime showTime;
}
