package com.example.StockTradingPlatform.service;

import com.example.StockTradingPlatform.model.StockPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockPriceService {
    private final RestTemplate restTemplate;

    @Value("${finnhub.api.url}")
    private String apiUrl;

    @Value("${finnhub.api.token}")
    private String apiToken;

    public StockPriceService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public StockPrice getStockPrice(String symbol) {
        String url = String.format("%s?symbol=%s&token=%s", apiUrl, symbol, apiToken);
        return restTemplate.getForObject(url, StockPrice.class);
    }

    public Map<String, StockPrice> getStockPrices(List<String> symbols) {
        Map<String, StockPrice> stockPrices = new HashMap<>();
        for (String symbol : symbols) {
            stockPrices.put(symbol, getStockPrice(symbol));
        }
        return stockPrices;
    }
}
