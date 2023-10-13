package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByImdbID(String imdbId);
}
