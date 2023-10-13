package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.entity.Shows;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatRequest {
    private int seatId;
    private int seatNum;
    private String row;
    private Hall hall;
}