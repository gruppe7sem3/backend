package com.example.kinoxpproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column; // Import the javax.persistence.Column annotation
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;

    @Column(length = 2000)
    private String plot;
    @Column(length = 2000)
    private String plotDK;
    private String poster;

    private String metascore;
    private String imdbRating;
    private String imdbVotes;

    @Column(unique = true)
    private String imdbID;
    private String website;
    private String response;

}
