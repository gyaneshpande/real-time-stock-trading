package com.example.StockTradingPlatform.controller;

import com.example.StockTradingPlatform.model.UserTransaction;
import com.example.StockTradingPlatform.service.UserTransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
public class UserTransactionController {
    private final UserTransactionService userTransactionService;
    public UserTransactionController(UserTransactionService userTransactionService) {
        this.userTransactionService = userTransactionService;
    }

    @GetMapping("/{id}")
    public UserTransaction getUserTransaction(@PathVariable long id) {
        return userTransactionService.getUserTransactionById(id);
    }

    @PostMapping("/{id}")
    public UserTransaction createUserTransaction(@RequestBody UserTransaction userTransaction, @PathVariable long id) {
        return userTransactionService.createUserTransaction(userTransaction, id);
    }
}
