package com.example.kinoxpproject.api_facade;

import com.example.kinoxpproject.dto.MovieOmdbResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbFacade {
  RestTemplate restTemplate;

  public OmdbFacade() {
    restTemplate = new RestTemplate();
  }

  @Value("${app.omdb-key:d79be994}")
  String API_KEY ;

  String OMDB_URL = "http://www.omdbapi.com";

  public MovieOmdbResponse getMovie(String imdbId) {
    String url = OMDB_URL+"/?apikey=" + API_KEY + "&plot=full" + "&i=";
    MovieOmdbResponse movieDTO = restTemplate.getForObject(url+imdbId, MovieOmdbResponse.class);
    return movieDTO;
  }
}

