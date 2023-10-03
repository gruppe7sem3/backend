package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
