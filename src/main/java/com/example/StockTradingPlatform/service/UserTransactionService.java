package com.example.StockTradingPlatform.service;
import com.example.StockTradingPlatform.model.UserAccount;
import com.example.StockTradingPlatform.repository.UserRepository;
import com.example.StockTradingPlatform.repository.UserTransactionRepository;
import com.example.StockTradingPlatform.model.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTransactionService {
    @Autowired
    private UserTransactionRepository userTransactionRepository;
    @Autowired
    private UserRepository userRepository;

    public Optional<UserTransaction> getAllUserTransaction(Long id) {
        return userTransactionRepository.findById(id);
    }

    public UserTransaction createUserTransaction(UserTransaction userTransaction, long user_id) {
        UserAccount user = userRepository.findById(user_id).orElse(null);
        UserTransaction newUserTransaction = new UserTransaction();
        newUserTransaction.setUserAccount(user);
        newUserTransaction.setStockName(userTransaction.getStockName());
        newUserTransaction.setPrice(userTransaction.getPrice());
        newUserTransaction.setCurrency(userTransaction.getCurrency());
        newUserTransaction.setQuantity(userTransaction.getQuantity());
        return userTransactionRepository.save(newUserTransaction);
    }

    public UserTransaction getUserTransactionById(Long id) {
        return userTransactionRepository.findById(id).orElse(null);
    }
}
