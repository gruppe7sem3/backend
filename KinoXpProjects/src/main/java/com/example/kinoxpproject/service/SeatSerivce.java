package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.repository.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatSerivce {

    private SeatRepository seatRepository;

    public Seat getSeatById(int seatId) {
        return seatRepository.getSeatById(seatId);
    }
}
