package com.example.fare.repository;

import com.example.fare.domain.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<Fare, Long> {
    Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
