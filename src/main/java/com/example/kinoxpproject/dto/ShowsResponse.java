package com.example.kinoxpproject.dto;

import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.entity.Shows;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowsResponse {
    private int showId;
    private int movieId;
    private int hallId;
    private LocalDate showDate;
    private LocalDateTime showTime;
    private String poster;  // Add a field for the movie poster

    public ShowsResponse(Shows shows, String imdbLink, Movie movie) {
        this.showId = shows.getShowId();
        this.movieId = shows.getMovieId().getId(); // Assuming Movie has an 'id' field
        this.hallId = shows.getHall().getHallId(); // Assuming Hall has an 'id' field
        this.showDate = shows.getShowDate();
        this.showTime = shows.getShowTime();
        this.poster = movie.getPoster(); // Set the poster from the Movie object
    }


}


