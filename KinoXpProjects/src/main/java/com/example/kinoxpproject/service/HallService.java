package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HallService {
    @Autowired
     HallRepository hallRepository;
    public Optional<Hall> getHallById(int hallId) {
        return hallRepository.findById(hallId);
    }
}
