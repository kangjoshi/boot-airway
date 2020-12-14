package com.example.fare.service;

import com.example.fare.domain.Fare;
import com.example.fare.repository.FareRepository;
import org.springframework.stereotype.Service;

@Service
public class FareService {

    private final FareRepository fareRepository;

    public FareService(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    public Fare getFare(String flightNumber, String flightDate) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return fareRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
    }
}
