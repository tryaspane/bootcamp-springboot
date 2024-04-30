package com.example.demo.interfaces;

import com.example.demo.common.dto.user.UpdateUserRequest;
import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    User createUser(User request);
    User updateUser(String nimUser, UpdateUserRequest request);
    Boolean deleteUser(String nimUser);
    List<User> getUsers();
    User getUser(String nimUser);
}
