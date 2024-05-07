package com.example.demo.service;

import com.example.demo.common.dto.userCredential.LoginRequest;
import com.example.demo.common.dto.userCredential.LoginResponse;
import com.example.demo.common.dto.userCredential.RegisterRequest;
import com.example.demo.common.dto.userCredential.RegisterResponse;
import com.example.demo.common.exceptions.InvalidUserException;
import com.example.demo.interfaces.IJwtService;
import com.example.demo.interfaces.IUserCredentialService;
import com.example.demo.model.UserCredential;
import com.example.demo.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService implements IUserCredentialService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private IJwtService iJwtService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        //get user by email/username
        //get password
        //compare password
        UserCredential data = userCredentialRepository.findByUserName(loginRequest.getUsername());

        if (data == null || bCryptPasswordEncoder.matches(loginRequest.getPassword(), data.getPassword())) {
            throw new InvalidUserException("invalid user");
        }

        String token = iJwtService.generateToken(data);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);

        return loginResponse;
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        //check username exist or not
        //buat password
        //masukin ke db
        //return token

        UserCredential currentData = userCredentialRepository.findByUserName(registerRequest.getUsername());

        if (currentData != null) {
            throw new InvalidUserException("username is exist");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(registerRequest.getPassword());

        UserCredential newUser = new UserCredential();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setRole("user");

        userCredentialRepository.save(newUser);

        String newToken = iJwtService.generateToken(newUser);

        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setToken(newToken);

        return registerResponse;
    }
}
