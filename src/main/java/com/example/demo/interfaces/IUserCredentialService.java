package com.example.demo.interfaces;

import com.example.demo.common.dto.userCredential.LoginRequest;
import com.example.demo.common.dto.userCredential.LoginResponse;
import com.example.demo.common.dto.userCredential.RegisterRequest;
import com.example.demo.common.dto.userCredential.RegisterResponse;

public interface IUserCredentialService {

    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);


}
