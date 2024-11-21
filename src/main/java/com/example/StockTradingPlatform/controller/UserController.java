package com.example.StockTradingPlatform.controller;

import com.example.StockTradingPlatform.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.example.StockTradingPlatform.model.UserAccount;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String getString() {
        return "test success 123456";
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserAccount updateUser(@PathVariable("id") Long id, @RequestBody UserAccount user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "user deleted";
    }
    
}
