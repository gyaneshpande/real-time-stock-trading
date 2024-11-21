package com.example.StockTradingPlatform.service;
import com.example.StockTradingPlatform.model.UserAccount;
import com.example.StockTradingPlatform.model.UserPortfolio;
import com.example.StockTradingPlatform.repository.UserPortfolioRepository;
import com.example.StockTradingPlatform.repository.UserRepository;
import com.example.StockTradingPlatform.repository.UserTransactionRepository;
import com.example.StockTradingPlatform.model.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTransactionService {
    private final UserPortfolioService userPortfolioService;

    @Autowired
    private UserTransactionRepository userTransactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPortfolioRepository userPortfolioRepository;

    public UserTransactionService(UserPortfolioService userPortfolioService) {
        this.userPortfolioService = userPortfolioService;
    }

    public Optional<UserTransaction> getAllUserTransaction(Long id) {
        return userTransactionRepository.findById(id);
    }

    public UserTransaction createUserTransaction(UserTransaction userTransaction, long user_id) {
        UserAccount user = userRepository.findById(user_id).orElseThrow();
        UserTransaction newUserTransaction = new UserTransaction();
        newUserTransaction.setUserAccount(user);
        newUserTransaction.setStockName(userTransaction.getStockName());
        newUserTransaction.setPrice(userTransaction.getPrice());
        newUserTransaction.setCurrency(userTransaction.getCurrency());
        newUserTransaction.setQuantity(userTransaction.getQuantity());
        UserPortfolio userPortfolio = new UserPortfolio();
        userPortfolio.setQuantity(userTransaction.getQuantity());
        userPortfolio.setPrice(userTransaction.getPrice());
        userPortfolio.setStockName(userTransaction.getStockName());
        userPortfolio.setUserAccount(user);
        userPortfolioService.createUserPortfolio(userPortfolio, user_id); // Create an entry in portfolio

        return userTransactionRepository.save(newUserTransaction);
    }

    public UserTransaction getUserTransactionById(Long id) {
        return userTransactionRepository.findById(id).orElse(null);
    }
}
