package com.example.StockTradingPlatform.repository;

import com.example.StockTradingPlatform.model.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTransactionRepository extends JpaRepository<UserTransaction, Long> {

}
