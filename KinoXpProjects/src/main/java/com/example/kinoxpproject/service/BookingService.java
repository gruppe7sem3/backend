package com.example.kinoxpproject.service;

import com.example.kinoxpproject.dto.BookingRequest;
import com.example.kinoxpproject.dto.BookingResponse;
import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.entity.Shows;
import com.example.kinoxpproject.repository.BookingRepository;
import com.example.kinoxpproject.repository.CustomerRepository;
import com.example.kinoxpproject.repository.SeatRepository;
import com.example.kinoxpproject.repository.ShowsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final ShowsRepository showsRepository;
    private final CustomerRepository customerRepository;


    public BookingService(BookingRepository bookingRepository, SeatRepository seatRepository,
                          ShowsRepository showsRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.showsRepository = showsRepository;
        this.customerRepository = customerRepository;
    }

    private double calculateTotalAmount(Booking booking) {
        // Implement your calculation logic based on the selected seat, show, etc.
        // You can customize this based on your business rules
        return 0.0;
    }


    // Get all bookings
    public List<BookingResponse> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream()
                .map(BookingResponse::new)
                .collect(Collectors.toList());
    }

    // Get a booking by ID
    public Booking getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Booking with this ID does not exist"));
    }
    public BookingResponse getBookingById2(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Booking with this ID does not exist"));
        return new BookingResponse(booking);
    }
    public List<Integer> getSeatIdsForShow(int showId) {
        return bookingRepository.findSeatIdsInBothSeatAndBookingForShow(showId);
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

    public void addBooking(BookingRequest bookingRequest) {
        // Retrieve Seat, Shows, and Customer entities based on IDs
        Seat seat = seatRepository.findById(bookingRequest.getSeatId())
                .orElseThrow(() -> new EntityNotFoundException("Seat not found"));

        Shows shows = showsRepository.findById(bookingRequest.getShowId())
                .orElseThrow(() -> new EntityNotFoundException("Show not found"));

        Customer customer = customerRepository.findById(bookingRequest.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        // Create a Booking entity from the BookingRequest
        Booking booking = bookingRequest.toBooking(seat, shows, customer);

        // Save the Booking entity
        bookingRepository.save(booking);
    }
}
