package com.example.StockTradingPlatform.service;

import com.example.StockTradingPlatform.model.UserAccount;
import com.example.StockTradingPlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    public UserAccount createUser(UserAccount user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Email already exists");
        }
    }

    public UserAccount getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount oldUser = getUserById(id);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(oldUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserAccount> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
