package com.example.fare.controller;

import com.example.fare.domain.Fare;
import com.example.fare.service.FareService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fares")
@Slf4j
public class FareController {

    private final FareService fareService;

    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/get")
    public Fare getFare(String flightNumber, String flightDate) {
        if (log.isDebugEnabled()) {
            log.debug("getFare for [{}], [{}]", flightNumber, flightDate);
        }

        return fareService.getFare(flightNumber, flightDate);
    }
}
