package com.student.gradingSystem.dto.course;

import com.student.gradingSystem.domain.entity.course.Course;

import java.io.Serializable;

public class CourseNameIdDTO implements Serializable {
    private String name;
    private Integer id;

    public CourseNameIdDTO(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public CourseNameIdDTO() {
    }

    public CourseNameIdDTO(Course course) {
        this.name=course.getName();
        this.id=course.getIdCourse();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
