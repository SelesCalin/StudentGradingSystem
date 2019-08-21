package com.student.gradingSystem.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable {
    private final String token;
    private final Integer role;

    public TokenDTO(String token,Integer role) {
        this.token = token;
        this.role=role;
    }

    public String getToken() {
        return token;
    }

    public Integer getRole(){ return role;}
}
