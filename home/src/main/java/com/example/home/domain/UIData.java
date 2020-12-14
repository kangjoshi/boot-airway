package com.example.home.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UIData {
    private SearchQuery searchQuery;

    private List<Flight> flights;
    private Flight selectedFlight;

    private Passenger passenger;

    private String bookingid;


}
