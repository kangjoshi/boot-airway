package com.example.home.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookingRecord {

    long id;

    private String flightNumber;
    private String origin;
    private String destination;
    private String flightDate;
    private Date bookingDate;
    private String fare;
    private String status;

    Set<Passenger> passengers;

    public BookingRecord(String flightNumber, String origin, String destination, String flightDate, Date bookingDate, String fare) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.bookingDate = bookingDate;
        this.fare = fare;
    }
}
