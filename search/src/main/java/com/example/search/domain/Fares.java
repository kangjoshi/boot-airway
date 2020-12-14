package com.example.search.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Fares {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "fare_id")
    long id;

    String fare;
    String currency;

    public Fares(String fare, String currency) {
        this.fare = fare;
        this.currency = currency;
    }
}
