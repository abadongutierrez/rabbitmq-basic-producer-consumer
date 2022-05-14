package com.jabaddon.rabbitmq.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
public class MessagePublisherController {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisherController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/publishMessage")
    public ResponseEntity<Map> publishMessage(@RequestBody Map<String, String> message) {
        rabbitTemplate.convertAndSend(
                MessageQueueConfiguration.MESSAGE_EXCHANGE,
                MessageQueueConfiguration.MESSAGE_ROUTING,
                new CustomMessage(UUID.randomUUID().toString(), message.get("message"), new Date()));
        return ResponseEntity.ok(Map.of("message", "Message Published"));
    }
}
