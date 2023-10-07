package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT DISTINCT s.seatId " +
            "FROM Seat s " +
            "INNER JOIN Booking b ON s.seatId = b.seat.seatId " +
            "WHERE b.shows.showId = :showId")
    List<Integer> findSeatIdsInBothSeatAndBookingForShow(int showId);

}
