package com.jabaddon.rabbitmq.mq;

import java.util.Date;

public record CustomMessage(String id, String message, Date date) {
}
