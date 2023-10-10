package com.example.kinoxpproject.config;

import com.example.kinoxpproject.dto.BookingRequest;
import com.example.kinoxpproject.dto.CustomerRequest;
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

    @Autowired
    HallService hallService;

    @Autowired
    CustomerService customerService;

    public void run(ApplicationArguments args) throws Exception {



        String data = showsService.findImdbidByShowId(1);
        System.out.println(data);
/*
        Hall hall = new Hall();
        hall.setHallId(1);
        hall.setCapacity(500);
        hall.setHallName("Sal 1");

        hallRepository.save(hall);

        Seat seat = seatSerivce.getSeatById(4);

        Seat seat2 = seatSerivce.getSeatById(2);

        Customer customer = new Customer();

        customer.setCustId(1);
        customer.setName("Susmita saidane");

        customerRepository.save(customer);

        Shows show = new Shows();
        show.setHall(hall);
        show.setShowId(1);
        show.setMovieId(movieService.getMovieByid(1));


       // showsRepository.save(show);


        Booking booking = new Booking();
        booking.setBookingId(1);
        booking.setSeat(seat);
        booking.setCustomer(customer);
        booking.setShows(show);

        Booking booking2 = new Booking();
        booking2.setBookingId(2);
        booking2.setSeat(seat2);
        booking2.setCustomer(customer);
        booking2.setShows(show);





        bookingRepository.save(booking);
        bookingRepository.save(booking2);
    Shows shows = new Shows();
        shows.setMovieId(movieService.getMovieByid(8));
        shows.setHall(hallService.getHallById(1));
        shows.setShowId(3);
        showsRepository.save(shows);

 */

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setCustomerId(1);
        bookingRequest.setShowId(7);
        bookingRequest.setSeatId(40);

        //bookingService.addBooking(bookingRequest);

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setEmail("yolo.com");
        customerRequest.setName("Ole kloak");

       // customerService.addCustomer(customerRequest);
        Customer customer = customerService.authLogin("hej", "hej");

       int i = customerRepository.getCustIdByNameAndPassword("hej", "hej");
        System.out.println(customer.getIsAdmin());




    }


}
