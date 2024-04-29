package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final Map<String, User> db = new HashMap<>();// String -> key dengan type data String dari class User

    @GetMapping(value = "/get", produces = "application/json")
    public ResponseEntity<List<User>> getUser(){
        List<User> result = new ArrayList<User>();
        result.addAll(db.values());
        return ResponseEntity.ok(result);//class untuk return response dari Rest itu seperti apa
    }

    @GetMapping(value = "/get/{nimUser}", produces = "application/json")
    public ResponseEntity<User> getDetailUser(@PathVariable String nimUser){
        User result = db.get(nimUser);
        return ResponseEntity.ok(result);//class untuk return response dari Rest itu seperti apa
    }

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<String> createUser(@RequestBody User request){
        db.put(request.getNimUser(),request);
        return ResponseEntity.ok("Create User");
    }

    @PostMapping(value = "/delete/{nimUser}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable String nimUser){
        db.remove(nimUser);
        return ResponseEntity.ok("Delete User");
    }

    @PostMapping(value = "/update/{nimUser}", produces = "application/json")
    public ResponseEntity<String> updateUser(@PathVariable String nimUser, @RequestBody User request){
        Boolean isExist = db.containsKey(nimUser);
         if(!isExist){
             return ResponseEntity.ok("Data Not Found");
         }
         User currentData = db.get(nimUser);
         currentData.setNamaUser(request.getNamaUser());
         currentData.setProdiUser(request.getProdiUser());

         db.put(currentData.getNimUser(), currentData);
        return ResponseEntity.ok("Data Updated");
    }

}
