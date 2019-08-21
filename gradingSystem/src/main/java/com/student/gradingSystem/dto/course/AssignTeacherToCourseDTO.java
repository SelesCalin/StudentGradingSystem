package com.student.gradingSystem.dto.course;

import java.io.Serializable;

public class AssignTeacherToCourseDTO implements Serializable {
    private Integer idTeacher;
    private Integer idCourse;

    public AssignTeacherToCourseDTO(Integer idTeacher, Integer idCourse) {
        this.idTeacher = idTeacher;
        this.idCourse = idCourse;
    }

    public AssignTeacherToCourseDTO() {
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
