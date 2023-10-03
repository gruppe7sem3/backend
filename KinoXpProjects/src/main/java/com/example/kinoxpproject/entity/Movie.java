package com.example.kinoxpproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column; // Import the javax.persistence.Column annotation
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id") // Specify the column name for movieId
    private int movieId;

    @Column(name = "movie_name") // Specify the column name for name
    private String name;

    @Column(name = "movie_description") // Specify the column name for description
    private String description;

    @Column(name = "movie_duration") // Specify the column name for duration
    private long duration;

    @Column(name = "movie_genre") // Specify the column name for genre
    private String genre;
}
