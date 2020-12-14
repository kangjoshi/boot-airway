package com.example.home.service;

import com.example.home.domain.BookingRecord;
import com.example.home.domain.Flight;
import com.example.home.domain.UIData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HomeService {

    private final RestTemplate restTemplate;

    public HomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Flight> searchFlight(UIData uiData) {
        List<Flight> flights = restTemplate.postForObject("http://localhost:8083/search/get", uiData.getSearchQuery(), List.class);
        return flights;
    }

    public long confirmBooking(BookingRecord booking) {
        long bookingId = 0l;
        try {
            bookingId = restTemplate.postForObject("http://localhost:8081/booking/create", booking, long.class);
            log.info("Booking created "+ bookingId);
        } catch (Exception e){
            e.printStackTrace();
            log.error("BOOKING SERVICE NOT AVAILABLE...!!!");
        }
        return bookingId;
    }
}
