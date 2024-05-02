package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String namaUser;

    @Column(unique = true)
    private String nimUser;
    private String prodiUser;

    public String getNamaUser() {
        return this.namaUser;
    }

    public String getNimUser() {
        return this.nimUser;
    }

    public String getProdiUser() {
        return this.prodiUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public void setNimUser(String nimUser) {
        this.nimUser = nimUser;
    }

    public void setProdiUser(String prodiUser) {
        this.prodiUser = prodiUser;
    }
}

