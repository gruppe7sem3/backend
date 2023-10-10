package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.entity.Shows;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowsRequest {
    private int show_id;
    private Movie movie_id;
    private Hall hall_id;
    private LocalDate show_date;
    private LocalDateTime show_time;


    public Shows ShowsBuilder() {
        return Shows.builder()
                .showId(show_id)
                .movieId(movie_id)
                .hall(hall_id)
                .showDate(show_date)
                .showTime(show_time)
                .build();
    }
}




