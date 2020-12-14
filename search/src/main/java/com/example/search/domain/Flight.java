package com.example.search.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String flightNumber;
    String origin;
    String destination;
    String flightDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fare_Id")
    Fares fares;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="inv_Id")
    Inventory inventory;

    public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares, Inventory inventory) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.fares = fares;
        this.inventory = inventory;
    }
}
