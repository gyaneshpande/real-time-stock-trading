package com.example.StockTradingPlatform.controller;

import com.example.StockTradingPlatform.model.UserPortfolio;
import com.example.StockTradingPlatform.service.UserPortfolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/portfolio")
public class UserPortfolioController {
    private final UserPortfolioService userPortfolioService;


    public UserPortfolioController(UserPortfolioService userPortfolioService) {
        this.userPortfolioService = userPortfolioService;
    }

    @GetMapping("/{id}")
    public Optional<UserPortfolio> getUserPortfolio(@PathVariable("id") Long id) {
        return userPortfolioService.getUserPortfolioByUserId(id);
    }


}
