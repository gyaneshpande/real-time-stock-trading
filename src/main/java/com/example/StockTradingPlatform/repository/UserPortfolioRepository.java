package com.example.StockTradingPlatform.repository;

import com.example.StockTradingPlatform.model.UserPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Long> {

}
