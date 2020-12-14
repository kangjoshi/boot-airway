package com.example.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    String firstName;
    String lastName;
    String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BOOKING_ID")
    @JsonIgnore
    private BookingRecord bookingRecord;


}
