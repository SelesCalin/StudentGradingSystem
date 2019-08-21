package com.student.gradingSystem.dto.user;

import com.student.gradingSystem.domain.entity.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private Integer id ;
    private String username;
    private String nume;
    private String email;
    private String adresa;

    public UserDTO(String username, String nume, String email, String adresa, Integer id) {
        this.username = username;
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
        this.id=id;
    }

    public UserDTO() {
    }

    public UserDTO(User user){
        adresa=user.getAdresa();
        email = user.getEmail();
        nume = user.getNume();
        username =user.getUsername();
        id=user.getIduser();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
