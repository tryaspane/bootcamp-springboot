package com.example.demo.repository;

import com.example.demo.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    UserCredential findByUserName(String username);

}
