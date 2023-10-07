package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatSerivce {
    @Autowired
    private SeatRepository seatRepository;

    public Optional<Seat> getSeatById(int seatId) {
        return seatRepository.findById(seatId);
    }
}
