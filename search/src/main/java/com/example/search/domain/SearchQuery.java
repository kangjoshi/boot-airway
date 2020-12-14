package com.example.search.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchQuery {

    String origin;
    String destination;
    String flightDate;

}
