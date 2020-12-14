package com.example.home.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Fares {

    long id;

    String fare;
    String currency;

    public Fares(String fare, String currency) {
        this.fare = fare;
        this.currency = currency;
    }
}
