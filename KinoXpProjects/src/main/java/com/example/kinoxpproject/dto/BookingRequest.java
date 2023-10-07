package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.entity.Seat;
import com.example.kinoxpproject.entity.Shows;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequest {
    private int seatId;
    private int showId;
    private int customerId;
    private double totalAmount;

    public Booking toBooking(Seat seat, Shows shows, Customer customer) {
        return Booking.builder()
                .seat(seat)
                .shows(shows)
                .customer(customer)
                .timestamp(new Date()) // Set the timestamp as needed
                .totalAmount(totalAmount)
                // Set other properties of the booking entity as needed
                .build();
    }
}