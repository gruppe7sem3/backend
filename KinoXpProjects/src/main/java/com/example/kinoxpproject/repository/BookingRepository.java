package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
