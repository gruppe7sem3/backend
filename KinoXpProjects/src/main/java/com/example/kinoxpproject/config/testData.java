package com.example.kinoxpproject.config;

import com.example.kinoxpproject.entity.*;
import com.example.kinoxpproject.repository.*;
import com.example.kinoxpproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

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
    @Autowired

    SeatService seatSerivce;

    @Autowired

    MovieService movieService;

    public void run(ApplicationArguments args) throws Exception {


        Hall hall = new Hall();
        hall.setHallId(1);
        hall.setCapacity(500);
        hall.setHallName("Sal 1");

        hallRepository.save(hall);

        Seat seat = seatSerivce.getSeatById(4);

        Customer customer = new Customer();

        customer.setCustId(1);
        customer.setName("Susmita saidane");

        customerRepository.save(customer);

        Shows show = new Shows();
        show.setHall(hall);
        show.setShowId(6);
        show.setMovieId(movieService.getMovieByid(1));

        showsRepository.save(show);


        Booking booking = new Booking();
        booking.setBookingId(1);
        booking.setSeat(seat);
        booking.setCustomer(customer);
        booking.setShows(show);



        bookingRepository.save(booking);


    }


}
