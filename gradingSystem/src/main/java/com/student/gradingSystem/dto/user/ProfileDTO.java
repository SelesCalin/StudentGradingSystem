package com.student.gradingSystem.dto.user;

import com.student.gradingSystem.domain.entity.User;

import java.io.Serializable;

public class ProfileDTO implements Serializable {
    private String username;
    private String nume;
    private String email;
    private String role;
    private String adresa;

    public ProfileDTO(String username, String nume, String email, String role, String adresa) {
        this.username = username;
        this.nume = nume;
        this.email = email;
        this.role = role;
        this.adresa = adresa;
    }

    public ProfileDTO() {
    }

    public ProfileDTO(User user){
        this.username=user.getUsername();
        this.adresa=user.getAdresa();
        this.email=user.getEmail();
        this.nume=user.getNume();
        this.role=user.getRole().toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
