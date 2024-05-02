package com.example.demo.controller;

import com.example.demo.common.dto.user.UpdateUserRequest;
import com.example.demo.interfaces.IUserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<User>> getUser(){
        List<User> result = iUserService.getUsers();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{nimUser}", produces = "application/json")
    public ResponseEntity<User> getDetailUser(@PathVariable String nimUser){
        User result = iUserService.getUser(nimUser);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User request){
        User result = iUserService.createUser(request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{nimUser}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable String nimUser){
        Boolean result = iUserService.deleteUser(nimUser);
        if(!result) return ResponseEntity.ok("Data Not Found");

        return  ResponseEntity.ok("Result");
    }

    @PutMapping(value = "/{nimUser}", produces = "application/json")
    public ResponseEntity<User> updateUser(@PathVariable String nimUser, @RequestBody UpdateUserRequest request){
        User result = iUserService.updateUser(nimUser, request);
        return ResponseEntity.ok(result);
    }

}
