package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.repository.BookingRepository;
import com.example.kinoxpproject.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;

    private final CustomerService customerService;
    private final ShowsService ShowService;

    public BookingService(BookingRepository bookingRepository, SeatRepository seatRepository, CustomerService customerService, ShowsService showService) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.customerService = customerService;
        ShowService = showService;
    }



    // Create a new booking


    // Implement your own logic to calculate the total amount
    private double calculateTotalAmount(Booking booking) {
        // Implement your calculation logic based on the selected seat, show, etc.
        // You can customize this based on your business rules
        return 0.0;
    }


    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get a booking by ID
    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // Update a booking
    public Booking updateBooking(Booking booking) {
        // Implement validation logic if needed
        return bookingRepository.save(booking);
    }

    // Delete a booking by ID
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
