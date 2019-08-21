package com.student.gradingSystem.dto;

import java.io.Serializable;

public class StringDTO implements Serializable {

    private String content;

    public StringDTO(String content) {
        this.content = content;
    }

    public StringDTO(){

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
