package com.example.StockTradingPlatform.service;

import com.example.StockTradingPlatform.dtos.LoginUserDto;
import com.example.StockTradingPlatform.dtos.RegisterUserDto;
import com.example.StockTradingPlatform.model.UserAccount;
import com.example.StockTradingPlatform.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserAccount signup(RegisterUserDto input) {
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(input.getFirstName());
        userAccount.setLastName(input.getLastName());
        userAccount.setEmail(input.getEmail());
        userAccount.setPassword(passwordEncoder.encode(input.getPassword()));
        userAccount.setDateOfBirth(input.getDateOfBirth());

        return userRepository.save(userAccount);
    }

    public UserAccount authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
        return userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow();
    }

}
