package com.example.book.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookingRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    private String flightNumber;
    private String origin;
    private String destination;
    private String flightDate;
    private Date bookingDate;
    private String fare;
    private String status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="bookingRecord")
    Set<Passenger> passengers;


}
