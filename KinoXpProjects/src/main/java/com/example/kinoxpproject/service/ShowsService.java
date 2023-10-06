package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Shows;
import com.example.kinoxpproject.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowsService {

    private final ShowsRepository showsRepository;

    @Autowired
    public ShowsService(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public Shows getShowById(int showId) {
        // Call the repository method to retrieve the show by ID
        return showsRepository.getShowById(showId);
    }
}
