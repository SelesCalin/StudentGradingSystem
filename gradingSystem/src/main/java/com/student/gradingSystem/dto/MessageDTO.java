package com.student.gradingSystem.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private String message;

    public MessageDTO(String message) {
        this.message = message;
    }

    public MessageDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
