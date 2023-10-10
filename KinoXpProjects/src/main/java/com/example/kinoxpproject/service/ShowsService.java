package com.example.kinoxpproject.service;

import com.example.kinoxpproject.dto.ShowsRequest;
import com.example.kinoxpproject.dto.ShowsResponse;
import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.entity.Shows;
import com.example.kinoxpproject.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShowsService {

    private final ShowsRepository showsRepository;

    @Autowired
    MovieService movieService;


    public ShowsService(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public Shows getShowById(int showId) {
        // Call the repository method to retrieve the show by ID
        return showsRepository.findById(showId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Show with this ID does not exist"));
    }
    public List<ShowsResponse> getAllShows() {
        List<Shows> shows = showsRepository.findAll();
        List<ShowsResponse> showsResponses = new ArrayList<>();

        for (Shows show : shows) {
            String imdbLink = findImdbidByShowId(show.getShowId());
            Movie movie = movieService.getMovieByImdbId(imdbLink);

            ShowsResponse showsResponse = new ShowsResponse(show, imdbLink, movie);
            showsResponses.add(showsResponse);
        }

        return showsResponses;
    }
    public List<Shows> getAllShows2() {
        return showsRepository.findAll();

    }
    public String findImdbidByShowId(int showId) {
        return showsRepository.findImdbIDByShowId(showId);
    }

    public Shows addShows(ShowsRequest showsRequest){
        Shows shows = showsRequest.ShowsBuilder();
        return showsRepository.save(shows);

    }

}
