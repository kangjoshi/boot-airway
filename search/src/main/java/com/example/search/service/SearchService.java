package com.example.search.service;

import com.example.search.domain.Flight;
import com.example.search.domain.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final FlightRepository flightRepository;

    public SearchService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<Flight> findFlight(SearchQuery searchQuery) {
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(searchQuery.getOrigin(), searchQuery.getDestination(), searchQuery.getFlightDate());

        return flights;
    }
}
