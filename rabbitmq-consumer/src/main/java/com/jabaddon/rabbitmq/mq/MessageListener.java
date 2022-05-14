package com.jabaddon.rabbitmq.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @RabbitListener(queues = MessageQueueConfiguration.MESSAGE_QUEUE)
    public void listener(CustomMessage message) {
        log.info("Message = {}", message);
    }
}
