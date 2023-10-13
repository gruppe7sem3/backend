package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer> {
    @Query("SELECT m.imdbID FROM Movie m JOIN Shows s ON s.movieId.id = m.id WHERE s.showId = :showId")
    String findImdbIDByShowId(int showId);

    Optional<Shows> findByshowId(int showId);







}
