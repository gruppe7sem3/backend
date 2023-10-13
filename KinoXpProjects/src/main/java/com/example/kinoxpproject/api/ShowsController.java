package com.example.kinoxpproject.api;

import com.example.kinoxpproject.dto.ShowsRequest;
import com.example.kinoxpproject.dto.ShowsResponse;
import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.entity.Shows;
import com.example.kinoxpproject.service.MovieService;
import com.example.kinoxpproject.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/shows")
public class ShowsController {

    private MovieService movieService;
    private ShowsService showsService;

    public ShowsController(ShowsService showsService, MovieService movieService) {
        this.showsService = showsService;
        this.movieService = movieService;
    }

    // Endpoint to get all shows
    @GetMapping
    public ResponseEntity<List<ShowsResponse>> getAllShows() {
        List<ShowsResponse> showsResponses = new ArrayList<>();
        List<Shows> shows = showsService.getAllShows2();

        for (Shows show : shows) {
            String imdbLink = showsService.findImdbidByShowId(show.getShowId());
            Movie movie = movieService.getMovieByImdbId(imdbLink);

            ShowsResponse showsResponse = new ShowsResponse(show, imdbLink, movie);
            showsResponses.add(showsResponse);
        }

        return new ResponseEntity<>(showsResponses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Shows addShows(@RequestBody ShowsRequest showsRequest) {
        // Create a Shows object from the request data
        return showsService.addShows(showsRequest);
    }

    @DeleteMapping("/delete/{showId}")
    public ResponseEntity<String> deleteShow(@PathVariable Integer showId) {
        // Call the service to delete the show by show ID
        Shows deleted = showsService.deleteShow(showId);

        if (deleted!=null) {
            return ResponseEntity.ok("Show deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Show not found or could not be deleted.");
        }
    }





}
