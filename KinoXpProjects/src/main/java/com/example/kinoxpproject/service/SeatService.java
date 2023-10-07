package com.example.kinoxpproject.service;

import com.example.kinoxpproject.dto.SeatResponse;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public Seat getSeatById(int seatId) {
        return seatRepository.findById(seatId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat with this ID does not exist"));
    }

    public SeatResponse getSeatById2(int seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat with this ID does not exist"));

        // Convert the Seat entity to a SeatResponse object
        return new SeatResponse(seat);
    }
}
