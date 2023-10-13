package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
