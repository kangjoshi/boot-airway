package com.example.home.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    long id;

    String firstName;
    String lastName;
    String gender;

    @JsonIgnore
    private BookingRecord bookingRecord;

}
