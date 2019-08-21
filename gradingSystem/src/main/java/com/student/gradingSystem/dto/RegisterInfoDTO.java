package com.student.gradingSystem.dto;

import java.io.Serializable;
import java.util.Objects;

public class RegisterInfoDTO implements Serializable {
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private Integer role;
    private Integer grupa;
    private String email ;
    private String adresa;

    public RegisterInfoDTO(String username, String password, String confirmPassword, String name, Integer role, Integer grupa, String email, String adresa) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.role = role;
        this.grupa = grupa;
        this.email = email;
        this.adresa = adresa;
    }

    public RegisterInfoDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getGrupa() {
        return grupa;
    }

    public void setGrupa(Integer grupa) {
        this.grupa = grupa;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterInfoDTO)) return false;
        RegisterInfoDTO that = (RegisterInfoDTO) o;
        return getUsername().equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }


    @Override
    public String toString() {
        return "RegisterInfoDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", grupa=" + grupa +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
