package com.example.demo.model;

public class BankUser {

    private String idUser;
    private String namaUser;
    private int balance;

    public String getIdUser() {
        return this.idUser;
    }

    public String getNamaUser() {
        return this.namaUser;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
