package com.example.kinoxpproject.service;

import com.example.kinoxpproject.entity.Customer;
import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;
    public Hall getHallById(int hallId) {
        return hallRepository.getHallById(hallId);
    }
}
