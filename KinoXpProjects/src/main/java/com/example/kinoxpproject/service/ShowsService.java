package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Shows;
import com.example.kinoxpproject.repository.ShowsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ShowsService {

    private final ShowsRepository showsRepository;


    public ShowsService(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public Shows getShowById(int showId) {
        // Call the repository method to retrieve the show by ID
        return showsRepository.findById(showId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Show with this ID does not exist"));
    }


}
