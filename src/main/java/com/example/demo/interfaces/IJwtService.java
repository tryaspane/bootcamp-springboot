package com.example.demo.interfaces;

import com.example.demo.model.UserCredential;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;

public interface IJwtService {
    String generateToken(UserCredential userCredential);
    Claims extractAllClaims(String token);
    Key getJwtKey();
    Date extractExpiration(String token);
    boolean isTokenValid(String token);
}
