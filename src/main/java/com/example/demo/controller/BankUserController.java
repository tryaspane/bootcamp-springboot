package com.example.demo.controller;

import com.example.demo.model.BankUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/bankuser")
public class BankUserController {

    private final Map<String, BankUser> db = new HashMap<>();

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<String> createUser (@RequestBody BankUser request){
        db.put(request.getIdUser(), request);
        return ResponseEntity.ok("Created Success");
    }

    @GetMapping(value = "/getUserDetail/{idUser}", produces = "application/json")
    public ResponseEntity<BankUser> detailUser (@PathVariable String idUser){
        BankUser result = db.get(idUser);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/topupBalance/{idUser}", produces = "application/json")
    public ResponseEntity<String> topUpBalance  (@PathVariable String idUser, @RequestBody BankUser request){
        Boolean isExist = db.containsKey(idUser);
        if(!isExist){
            return ResponseEntity.ok("Data Not Found");
        }

        BankUser currentData = db.get(idUser);
        currentData.setBalance(request.getBalance() + currentData.getBalance());
        db.put(currentData.getIdUser(), currentData);
        return ResponseEntity.ok("Data Updated");

    }

    @PostMapping(value = "/spendBalance/{idUser}", produces = "application/json")
    public ResponseEntity<String> spendBalance  (@PathVariable String idUser, @RequestBody BankUser request){
        Boolean isExist = db.containsKey(idUser);
        if(!isExist){
            return ResponseEntity.ok("Data Not Found");
        }

        BankUser currentData = db.get(idUser);
        int currentBalance = currentData.getBalance();
        int spendBalance = request.getBalance();

        if (currentBalance < spendBalance){
            return ResponseEntity.ok("Insufficient Balance");
        } else {
            currentData.setBalance(currentBalance - spendBalance);
            db.put(currentData.getIdUser(), currentData);
            return ResponseEntity.ok("Spend Balance Success");
        }

    }

}
