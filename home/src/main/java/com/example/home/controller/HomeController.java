package com.example.home.controller;

import com.example.home.domain.*;
import com.example.home.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Slf4j
public class HomeController {

    private final HomeService homeService;

    HomeController (HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String searchForm(Model model) {
        SearchQuery query = new  SearchQuery("NYC","SFO","22-JAN-18");

        UIData uiData = new UIData();
        uiData.setSearchQuery(query);

        model.addAttribute("uidata", uiData);
        return "search";
    }

    @PostMapping("/search")
    public String searchFlight(UIData uiData, Model model) {
        log.debug("search flight");
        List<Flight> flights = homeService.searchFlight(uiData);

        uiData.setFlights(flights);

        model.addAttribute("uidata", uiData);
        return "result";
    }

    @GetMapping("/book/{flightNumber}/{origin}/{destination}/{flightDate}/{fare}")
    public String bookForm(@PathVariable String flightNumber,
                           @PathVariable String origin,
                           @PathVariable String destination,
                           @PathVariable String flightDate,
                           @PathVariable String fare, Model model) {
        UIData uiData = new UIData();

        Flight flight = new Flight(flightNumber, origin,destination,flightDate,new Fares(fare,"AED"));
        uiData.setSelectedFlight(flight);
        uiData.setPassenger(new Passenger());

        model.addAttribute("uidata", uiData);
        return "book";
    }

    @PostMapping("/confirm")
    public String bookConfirm(UIData uiData, Model model) {
        Flight flight= uiData.getSelectedFlight();
        BookingRecord booking = new BookingRecord(flight.getFlightNumber(),flight.getOrigin(),
                flight.getDestination(), flight.getFlightDate(),null,
                flight.getFares().getFare());

        Set<Passenger> passengers = new HashSet<Passenger>();
        Passenger pax = uiData.getPassenger();
        pax.setBookingRecord(booking);
        passengers.add(uiData.getPassenger());
        booking.setPassengers(passengers);

        long bookingId = homeService.confirmBooking(booking);
        model.addAttribute("message", "Your Booking is confirmed. Reference Number is "+ bookingId);
        return "confirm";
    }


}
