package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat getSeatById(int seatId);
}
