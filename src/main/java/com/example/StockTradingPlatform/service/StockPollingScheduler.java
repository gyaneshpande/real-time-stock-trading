package com.example.StockTradingPlatform.service;

import com.example.StockTradingPlatform.config.StockConfig;
import com.example.StockTradingPlatform.model.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StockPollingScheduler {
    private final StockPriceService stockPriceService;
    private final StockConfig stockConfig;
    private final StockPricePublisher stockPricePublisher;

    @Autowired
    public StockPollingScheduler(StockPriceService stockPriceService, StockConfig stockConfig, StockPricePublisher stockPricePublisher) {
        this.stockPriceService = stockPriceService;
        this.stockConfig = stockConfig;
        this.stockPricePublisher = stockPricePublisher;
    }

    @Scheduled(fixedRate = 60000)
    public void fetchAndLogStockPrices() {
        Map<String, StockPrice> stockPrices = stockPriceService.getStockPrices(stockConfig.getSymbols());

        stockPrices.forEach((symbol, price) -> {
            String message = "Symbol " + symbol + ", " + "Current price: " + price.getC() + " at time " + price.getT();
            stockPricePublisher.sendStockPrice(symbol, price.getC());
        });


    }
}
