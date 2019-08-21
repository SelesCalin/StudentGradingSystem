package com.student.gradingSystem.dto.user;

import java.io.Serializable;
import java.util.List;

public class TeacherDTO extends UserDTO implements Serializable  {
    private List<String> coursesNames;

    public TeacherDTO(List<String> coursesNames) {
        this.coursesNames = coursesNames;
    }

    public TeacherDTO() {
    }

    public List<String> getCoursesNames() {
        return coursesNames;
    }

    public void setCoursesNames(List<String> coursesNames) {
        this.coursesNames = coursesNames;
    }
}
