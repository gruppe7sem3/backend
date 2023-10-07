package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer> {

    Shows getShowById(int showId);

    @Query(value = "INSERT INTO shows (movie_id, hall_id, show_date, show_time) VALUES (:movieId, :hallId, :showDate, :showTime)", nativeQuery = true)
    void createShow(@Param("movieId") int movieId, @Param("hallId") int hallId, @Param("showDate") LocalDate showDate, @Param("showTime") LocalDateTime showTime);
}
