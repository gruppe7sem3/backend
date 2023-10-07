package com.example.kinoxpproject.config;

import com.example.kinoxpproject.entity.*;
import com.example.kinoxpproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class testData implements ApplicationRunner {

    @Autowired
    MovieService movieService;
    BookingService bookingService;
    SeatSerivce seatSerivce;
    ShowsService showsService;
    HallService hallService;
    CustomerService customerService;


    public void run(ApplicationArguments args) throws Exception {
        //Create Movie
        Movie movie = new Movie();
// Set movie properties (e.g., title, year, etc.)
        movie = movieService.addMovie("tt1234567"); // Assuming "tt1234567" is an IMDb ID

        //Create Show
        Shows show = new Shows();
        show.setMovie(Movie); // Set the movie for the show
        Hall hall;
        show.setHall(Hall);   // Set the hall for the show
        show.setShowDate(LocalDate.of(2023, 10, 15)); // Set the show date
        show.setShowTime(LocalDateTime.of(2023, 10, 15, 18, 30)); // Set the show time

        show = showsService.createShow(show); // Create the show

        //Create Seat
        List<Seat> seats = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {
            for (int seatNum = 1; seatNum <= numSeatsPerRow; seatNum++) {
                Seat seat = new Seat();
                seat.setSeatNum(String.valueOf(seatNum));
                seat.setRow(String.valueOf(row));
                seat.setHall(hall); // Set the hall for the seat
                seats.add(seat);
            }
        }

        seatService.createSeats(seats); // Create the seats

        //Create booking
        Booking booking = new Booking();
        booking.setShows(show);   // Set the show for the booking
        booking.setSeat(seats.get(0)); // Set the seat for the booking (assuming you have seats list)
        booking.setCustomer(Customer); // Set the customer for the booking
        booking.setTimestamp(new Date()); // Set the booking timestamp
        booking.setTotalAmount(25.0); // Set the total amount

        booking = bookingService.createBooking(booking); // Create the booking




    }


}
