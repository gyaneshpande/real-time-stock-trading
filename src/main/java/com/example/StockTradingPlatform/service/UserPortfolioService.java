package com.example.StockTradingPlatform.service;

import com.example.StockTradingPlatform.model.UserAccount;
import com.example.StockTradingPlatform.model.UserPortfolio;
import com.example.StockTradingPlatform.repository.UserPortfolioRepository;
import com.example.StockTradingPlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPortfolioService {
    @Autowired
    UserPortfolioRepository userPortfolioRepository;

    @Autowired
    UserRepository userRepository;

    public Optional<UserPortfolio> getUserPortfolioByUserId(Long userId) {
        return userPortfolioRepository.findById(userId);
    }

    public void createUserPortfolio(UserPortfolio userPortfolio, long id) {
        UserAccount userAccount = userRepository.findById(id).orElseThrow();
        UserPortfolio newUserPortfolio = new UserPortfolio();
        newUserPortfolio.setUserAccount(userAccount);
        newUserPortfolio.setPrice(userPortfolio.getPrice());
        newUserPortfolio.setStockName(userPortfolio.getStockName());
        newUserPortfolio.setQuantity(userPortfolio.getQuantity());
        userPortfolioRepository.save(newUserPortfolio);
    }

    public double getTotalPortfolioValue(long id) {
        Optional<UserPortfolio> userPortfolio = getUserPortfolioByUserId(id);
        return userPortfolio.map(portfolio -> portfolio.getQuantity() * portfolio.getPrice())
                .orElse(0.0); // Return 0 if no portfolio is present
    }


}
