package com.example.book.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    RabbitMessagingTemplate template;

    public Sender(RabbitMessagingTemplate template) {
        this.template = template;
    }

    @Bean
    Queue queue() {
        return new Queue("SearchQ", false);
    }

    public void send(Object message){
        template.convertAndSend("SearchQ", message);
    }

}
