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

    @Autowired
    public BookingService(BookingRepository bookingRepository, SeatRepository seatRepository, CustomerService customerService, ShowsService showService) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.customerService = customerService;
        ShowService = showService;
    }

    // Create a new booking
    public Booking createBooking(int showId, int customerId, Booking booking) {
        // Implement validation logic if needed

        // Create a new seat
        Seat seat = new Seat();
        seat.setSeatNum(booking.getSeat().getSeatNum());
        seat.setRow(booking.getSeat().getRow());
        // Set the hall for the seat (you may need to retrieve it based on showId)
        // seat.setHall(hallService.getHallByShowId(showId));

        // Create the seat in the database
        seat = seatRepository.save(seat);

        // Set the newly created seat in the booking
        booking.setSeat(seat);

        // Set the show and customer in the booking (assuming you have services for them)
        booking.setShows(ShowService.getShowById(showId));
        booking.setCustomer(customerService.getCustomerById(customerId));

        // Set the booking timestamp and total amount
        booking.setTimestamp(new Date()); // You can customize this logic
        booking.setTotalAmount(calculateTotalAmount(booking)); // Implement your own calculation logic

        // Create the booking
        return bookingRepository.save(booking);
    }

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
