package com.example.StockTradingPlatform.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockPricePublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public StockPricePublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStockPrice(String stockSymbol, Double stockPrice) {
        // Create a value object with additional attributes
        String value = String.format("{\"price\": %s, \"timestamp\": \"%s\"}",
                stockPrice,
                System.currentTimeMillis());

        // Log the message being sent
        System.out.println("Message to Kafka: Key=" + stockSymbol + ", Value=" + value + " on topic: " + topicName);

        // Send the message with the stockSymbol as key and value as a JSON-like string
        kafkaTemplate.send(topicName, stockSymbol, value);

        System.out.println("Sent message to Kafka: Key=" + stockSymbol + ", Value=" + value);
    }
}
