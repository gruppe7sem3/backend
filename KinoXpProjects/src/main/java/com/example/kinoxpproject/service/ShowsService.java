package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Shows;
import com.example.kinoxpproject.repository.ShowsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowsService {

    private final ShowsRepository showsRepository;


    public ShowsService(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public Optional<Shows> getShowById(int showId) {
        // Call the repository method to retrieve the show by ID
        return showsRepository.findById(showId);
    }
}
