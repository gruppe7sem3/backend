package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Booking;
import com.example.kinoxpproject.entity.Seat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {

    private int bookingId;
    private int seatId;
    private int showId;
    private int customerId;
    private Date timestamp;
    private double totalAmount;

    public BookingResponse(Booking booking){
        this.bookingId = booking.getBookingId();
        this.seatId = booking.getSeat().getSeatId();
        this.showId = booking.getShows().getShowId();
        this.customerId = booking.getCustomer().getCustId();
        this.timestamp = booking.getTimestamp();
        this.totalAmount = booking.getTotalAmount();
    }
}







