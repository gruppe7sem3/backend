package com.example.kinoxpproject.repository;

import com.example.kinoxpproject.entity.Hall;
import com.example.kinoxpproject.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall, Integer> {


}
