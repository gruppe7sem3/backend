package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class HallService {
    @Autowired
     HallRepository hallRepository;
    public Hall getHallById(int hallId) {
        return hallRepository.findById(hallId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hall with this ID does not exist"));
    }
}
