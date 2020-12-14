package com.example.search;

import com.example.search.domain.Fares;
import com.example.search.domain.Flight;
import com.example.search.domain.Inventory;
import com.example.search.service.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SearchApplication implements CommandLineRunner {

	@Autowired
	private FlightRepository flightRepository;

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("BF100", "SEA","SFO","22-JAN-18",new Fares("100", "USD"),new Inventory(100)));
		flights.add(new Flight("BF101", "NYC","SFO","22-JAN-18",new Fares("101", "USD"),new Inventory(100)));
		flights.add(new Flight("BF105", "NYC","SFO","22-JAN-18",new Fares("105", "USD"),new Inventory(100)));
		flights.add(new Flight("BF106", "NYC","SFO","22-JAN-18",new Fares("106", "USD"),new Inventory(100)));
		flights.add(new Flight("BF102", "CHI","SFO","22-JAN-18",new Fares("102", "USD"),new Inventory(100)));
		flights.add(new Flight("BF103", "HOU","SFO","22-JAN-18",new Fares("103", "USD"),new Inventory(100)));
		flights.add(new Flight("BF104", "LAX","SFO","22-JAN-18",new Fares("104", "USD"),new Inventory(100)));

		flightRepository.saveAll(flights);
	}
}
