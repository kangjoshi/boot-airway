package com.example.fare.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String flightNumber;
    String flightDate;
    String fare;

    public Fare(String flightNumber, String flightDate, String fare) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.fare = fare;
    }
}
