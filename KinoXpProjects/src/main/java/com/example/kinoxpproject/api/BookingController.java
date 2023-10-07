package com.example.kinoxpproject.api;

import com.example.kinoxpproject.dto.BookingResponse;
import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create a new booking

    // Get all bookings
    @GetMapping
    public List<BookingResponse> getAllBookings() {
       return bookingService.getAllBookings();

    }
    @GetMapping("/{bookingId}")
    public BookingResponse getAllBookings(@PathVariable int bookingId) {
        return bookingService.getBookingById2(bookingId);

    }

    @GetMapping("/seatIdsForShow/{showId}")
    public List<Integer> getSeatIdsForShow(@PathVariable int showId) {
        return bookingService.getSeatIdsForShow(showId);
    }

    // Get a booking by ID

    // Update a booking
}
