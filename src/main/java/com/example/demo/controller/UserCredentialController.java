package com.example.demo.controller;

import com.example.demo.common.dto.userCredential.LoginRequest;
import com.example.demo.common.dto.userCredential.LoginResponse;
import com.example.demo.common.dto.userCredential.RegisterRequest;
import com.example.demo.common.dto.userCredential.RegisterResponse;
import com.example.demo.interfaces.IUserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public/user")
public class UserCredentialController {
    @Autowired
    private IUserCredentialService iUserCredentialService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = iUserCredentialService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = iUserCredentialService.register(registerRequest);
        return ResponseEntity.ok(registerResponse);
    }
}
