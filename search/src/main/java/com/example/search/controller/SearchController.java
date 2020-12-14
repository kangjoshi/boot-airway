package com.example.search.controller;

import com.example.search.component.Receiver;
import com.example.search.domain.Flight;
import com.example.search.domain.SearchQuery;
import com.example.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    private final SearchService searchService;
    private final Receiver receiver;

    public SearchController(SearchService searchService, Receiver receiver) {
        this.searchService = searchService;
        this.receiver = receiver;
    }

    @PostMapping("/get")
    public List<Flight> getFlights(@RequestBody SearchQuery searchQuery) {
        log.debug("Search Flights query = [{}]", searchQuery.toString());

        return searchService.findFlight(searchQuery);
    }

    @GetMapping("/mq")
    public void getMq() {


    }

}
