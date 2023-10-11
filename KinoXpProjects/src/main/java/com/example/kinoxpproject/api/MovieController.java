package com.example.kinoxpproject.api;


import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {

  MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;

  }

  @RequestMapping("/imdbid/{imdbId}")
  public Movie getMovie(@PathVariable String imdbId) {
    return movieService.getMovieByImdbId(imdbId);
  }

  @PostMapping
  public Movie addMovie(@RequestParam("imdbId") String imdbId, @RequestParam("trailerLink") String trailerLink) throws JsonProcessingException {
    return movieService.addMovie(imdbId, trailerLink);
  }


  @GetMapping("/all")
  public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }



  }

