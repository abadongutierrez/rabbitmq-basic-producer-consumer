package com.jabaddon.rabbitmq.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/publishMessage")
    public void publishMessage(@RequestBody CustomMessage message) {
        var customMessage = new CustomMessage(UUID.randomUUID().toString(), message.message(), LocalDate.now());
    }
}
