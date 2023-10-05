package com.example.kinoxpproject.api;


import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieController {

  MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @CrossOrigin(origins = "http://127.0.0.1:5501") // Allow requests from this origin
  @RequestMapping("/imdbid/{imdbId}")
  public Movie getMovie(@PathVariable String imdbId) {
    return movieService.getMovieByImdbId(imdbId);
  }
  @PostMapping("/{imdbId}")
  public Movie addMovie(@PathVariable String imdbId) throws JsonProcessingException {
    return movieService.addMovie(imdbId);
  }

  }
