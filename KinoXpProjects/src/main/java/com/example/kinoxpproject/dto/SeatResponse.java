package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.entity.Seat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SeatResponse {

    private int seatId;
    private String seatNum;
    private String row;
    private int hallId;

    public SeatResponse(Seat seat){
        this.seatId = seat.getSeatId();
        this.hallId = seat.getHall().getHallId();

    }

    }

