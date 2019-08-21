package com.student.gradingSystem.dto.user;

import com.student.gradingSystem.domain.entity.User;

import java.io.Serializable;

public class UpdateUserDTO implements Serializable {
    private String username;
    private String nume;
    private String email;
    private String adresa;
    private Integer grupa;
    private Integer role;

    public UpdateUserDTO(String username, String nume, String email, String adresa, Integer grupa, Integer role) {
        this.username = username;
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
        this.grupa = grupa;
        this.role = role;
    }

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(User user){
        this.username=user.getUsername();
        this.nume=user.getNume();
        this.adresa=user.getAdresa();
        this.email=user.getEmail();
        this.grupa=user.getGrupa();
        this.role=user.getRole().ordinal();
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getGrupa() {
        return grupa;
    }

    public void setGrupa(Integer grupa) {
        this.grupa = grupa;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
