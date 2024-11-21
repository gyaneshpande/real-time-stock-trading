package com.example.StockTradingPlatform.service;

import com.example.StockTradingPlatform.repository.UserPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPortfolioService {
    @Autowired
    UserPortfolioRepository userPortfolioRepository;


}
