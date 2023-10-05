package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByImdbID(String imdbId);
}
