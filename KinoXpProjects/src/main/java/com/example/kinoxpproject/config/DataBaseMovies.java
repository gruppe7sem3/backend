package com.example.kinoxpproject.config;


import com.example.kinoxpproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataBaseMovies implements ApplicationRunner {

    @Autowired
    MovieService movieService;


    public void run(ApplicationArguments args) throws Exception {
        movieService.addMovie("tt1517268");
        movieService.addMovie("tt3291150");
        movieService.addMovie("tt17024450");
        movieService.addMovie("tt11858890");
        movieService.addMovie("tt22687790");
        movieService.addMovie("tt0078346");
        movieService.addMovie("tt0439572");
        movieService.addMovie("tt0443453");
        movieService.addMovie("tt1645170");
        movieService.addMovie("tt0109686");
        movieService.addMovie("tt4425200");


    }


}
