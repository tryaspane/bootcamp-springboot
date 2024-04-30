package com.example.demo.common.dto.user;

public class UpdateUserRequest {
    private String namaUser;
    private String prodiUser;

    public String getNamaUser() {
        return namaUser;
    }

    public String getProdiUser() {
        return prodiUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public void setProdiUser(String prodiUser) {
        this.prodiUser = prodiUser;
    }
}
