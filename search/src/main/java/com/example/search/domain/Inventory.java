package com.example.search.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "inv_id")
    long id;

    int count;

    public Inventory(int count) {
        this.count = count;
    }
}
