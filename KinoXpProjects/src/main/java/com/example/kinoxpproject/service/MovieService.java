package com.example.kinoxpproject.service;

import com.example.kinoxpproject.api_facade.OmdbFacade;
import com.example.kinoxpproject.dto.MovieOmdbResponse;
import com.example.kinoxpproject.entity.Movie;
import com.example.kinoxpproject.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MovieService {

    @Autowired
    OmdbFacade omdbFacade;
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Movie getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbID(imdbId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }

    public Movie addMovie(String imdbId) throws JsonProcessingException {
        MovieOmdbResponse dto = omdbFacade.getMovie(imdbId);
        //String dkPlot = translator.translate(dto.getPlot());

        Movie movie = Movie.builder()

                .title(dto.getTitle())
                .year(dto.getYear())
                .rated(dto.getRated())
                .released(dto.getReleased())
                .runtime(dto.getRuntime())
                .genre(dto.getGenre())
                .director(dto.getDirector())
                .writer(dto.getWriter())
                .actors(dto.getActors())
                .metascore(dto.getMetascore())
                .imdbRating(dto.getImdbRating())
                .imdbVotes(dto.getImdbVotes())
                .website(dto.getWebsite())
                .response(dto.getResponse())
                .plot(dto.getPlot())
                //.plotDK(dkPlot)
                .poster(dto.getPoster())
                .imdbID(dto.getImdbID())
                .build();
        try {
            movieRepository.save(movie);
            return movie;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getRootCause().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add movie");
        }
    }
}
