package com.example.book.service;

import com.example.book.component.BookingException;
import com.example.book.component.Sender;
import com.example.book.domain.BookingRecord;
import com.example.book.domain.Fare;
import com.example.book.domain.Passenger;
import com.example.book.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class BookingService {

    private WebClient webClient;
    private final BookingRepository bookingRepository;
    private final Sender sender;
    public BookingService(BookingRepository bookingRepository, Sender sender) {
        this.webClient = WebClient.create("http://localhost:8082");
        this.bookingRepository = bookingRepository;
        this.sender = sender;
    }

    public long booking(BookingRecord bookingRecord) {
        if (log.isDebugEnabled()) {
            log.debug("Booking start");
        }

        validateFare(bookingRecord);

        bookingRecord.setStatus("BOOKING_CONFIRMED");
        Set<Passenger> passengers = bookingRecord.getPassengers();
        passengers.forEach(passenger -> passenger.setBookingRecord(bookingRecord));
        bookingRecord.setBookingDate(new Date());
        long id=  bookingRepository.save(bookingRecord).getId();

        Map<String, Object> bookingDetails = new HashMap<String, Object>();
        bookingDetails.put("FLIGHT_NUMBER", bookingRecord.getFlightNumber());
        bookingDetails.put("FLIGHT_DATE", bookingRecord.getFlightDate());
        bookingDetails.put("NEW_INVENTORY", 99);
        sender.send(bookingDetails);

        if (log.isDebugEnabled()) {
            log.debug("Booking End");
        }
        return 0;
    }

    private void validateFare(BookingRecord bookingRecord) {
        Mono<Fare> result = this.webClient.get()
                .uri("/fares/get?flightNumber="+bookingRecord.getFlightNumber()+"&flightDate="+bookingRecord.getFlightDate())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> response.bodyToMono(Fare.class));

        result.subscribe(fare -> checkFare(bookingRecord.getFare(), fare.getFare()));
    }

    private void checkFare(String requestedFare, String actualfare) {
        if (!requestedFare.equals(actualfare))
            throw new BookingException("fare is tampered");
    }

}
