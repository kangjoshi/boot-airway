package com.example.home.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Flight {

    long id;

    String flightNumber;
    String origin;
    String destination;
    String flightDate;

    Fares fares;

    public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.fares = fares;
    }
}
