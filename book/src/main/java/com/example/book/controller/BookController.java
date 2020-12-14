package com.example.book.controller;

import com.example.book.domain.BookingRecord;
import com.example.book.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@Slf4j
public class BookController {

    private final BookingService bookingService;

    public BookController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public long booking(@RequestBody BookingRecord bookingRecord) {

        if (log.isDebugEnabled()) {
            log.debug("Booking Request [{}]", bookingRecord);
        }

        return bookingService.booking(bookingRecord);
    }


}
