package com.student.gradingSystem.dto.course;

import java.io.Serializable;

public class EnrollDTO implements Serializable {
    private String enrollmentKey;
    private Integer id;

    public EnrollDTO(String enrollmentKey, Integer id) {
        this.enrollmentKey = enrollmentKey;
        this.id = id;
    }

    public EnrollDTO() {
    }

    public String getEnrollmentKey() {
        return enrollmentKey;
    }

    public void setEnrollmentKey(String enrollmentKey) {
        this.enrollmentKey = enrollmentKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
