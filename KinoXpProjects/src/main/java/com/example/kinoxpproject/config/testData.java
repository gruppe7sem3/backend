package com.example.kinoxpproject.config;

import com.example.kinoxpproject.entity.*;
import com.example.kinoxpproject.repository.*;
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
import java.util.Optional;

@Configuration
public class testData implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    ShowsRepository showsRepository;
    @Autowired
    ShowsService showsService;
    @Autowired
    BookingService bookingService;

    public void run(ApplicationArguments args) throws Exception {


        Hall hall = new Hall();
        hall.setHallId(2);
        System.out.println(hall);


        hallRepository.save(hall);

        Seat seat = new Seat();
        seat.setSeatId(1);
        seat.setHall(hall);

        seatRepository.save(seat);

        Customer customer = new Customer();

        customer.setCustId(1);
        customer.setName("Susmita saidane");

        customerRepository.save(customer);


        Booking booking = new Booking();
        booking.setBookingId(1);
        booking.setSeat(seat);
        booking.setCustomer(customer);

        bookingRepository.save(booking);

        Optional<Booking> booking1 = bookingService.getBookingById(1);
        System.out.println(booking1);




        //show = showsService.createShow(show); // Create the show

        //Create Seat


        //seatService.createSeats(seats); // Create the seats





    }


}
