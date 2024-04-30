package com.example.demo.service;

import com.example.demo.common.dto.user.UpdateUserRequest;
import com.example.demo.interfaces.IUserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //to inform this file is as Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User request) {
        userRepository.save(request);
        return request;
    }

    @Override
    public User updateUser(String nimUser, UpdateUserRequest request) {
        User currentData = userRepository.findByNimUser(nimUser);

        if(currentData == null){
            return null;
        }

        currentData.setNamaUser(request.getNamaUser());
        currentData.setProdiUser(request.getProdiUser());

        userRepository.save(currentData);
        return currentData;
    }

    @Override
    public Boolean deleteUser(String nimUser) {
        User currentData = userRepository.findByNimUser(nimUser);

        if(currentData == null){
            return false;
        }

        userRepository.delete(currentData);
        return true;
    }

    @Override
    public List<User> getUsers() {
        List<User> result = userRepository.findAll();
        return  result;
    }

    @Override
    public User getUser(String nimUser) {
        return userRepository.findByNimUser(nimUser);
    }
}
