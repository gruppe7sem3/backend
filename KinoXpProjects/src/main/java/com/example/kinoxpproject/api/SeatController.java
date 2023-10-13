package com.example.kinoxpproject.api;
import com.example.kinoxpproject.dto.SeatResponse;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{seatId}")
    public SeatResponse getSeatById(@PathVariable int seatId) {
        return seatService.getSeatById2(seatId);
    }
}
