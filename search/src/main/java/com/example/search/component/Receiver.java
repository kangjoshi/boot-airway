package com.example.search.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Receiver {

    @Bean
    Queue queue() {
        return new Queue("SearchQ", false);
    }

    @RabbitListener(queues = "SearchQ")
    public void processMessage(Map<String,Object> fare) {
        System.out.println(fare);
        //call repository and update the fare for the given flight
    }

}
