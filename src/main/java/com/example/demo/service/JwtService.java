package com.example.demo.service;

import com.example.demo.interfaces.IJwtService;
import com.example.demo.model.UserCredential;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService implements IJwtService {
    @Override
    public String generateToken(UserCredential userCredential) {
        Instant now = Instant.now();
        Instant expirationTime = now.plusSeconds(24 * 60 * 60);

        return Jwts.builder().
                setSubject(userCredential.getUsername()).
                claim("role", userCredential.getRole()).
                claim("id", userCredential.getId()).
                setExpiration(Date.from(expirationTime)).
                signWith(SignatureAlgorithm.HS256, getJwtKey()).
                compact();
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getJwtKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public Key getJwtKey() {
        byte[] keyBytes = Decoders.BASE64.decode("belajarspringboot");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    @Override
    public boolean isTokenValid(String token) {
        return extractExpiration(token).before(new Date());
    }
}
