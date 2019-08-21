package com.student.gradingSystem.dto.course;

import com.student.gradingSystem.domain.entity.course.Course;

public class CourseDTO {
    private Integer id;
    private String name;
    private String description;
    private String teacherUsername;
    private String enrollmentKey;

    public CourseDTO(String name, String description, String teacherUsername, String enrollmentKey, Integer id) {
        this.name = name;
        this.description = description;
        this.teacherUsername = teacherUsername;
        this.enrollmentKey=enrollmentKey;
        this.id=id;
    }

    public CourseDTO(Course course){
        this.name= course.getName();
        this.description=course.getDescription();
        this.enrollmentKey=course.getEnrollmentKey();
        this.teacherUsername=course.getTeacher().getUsername();
        this.id=course.getIdCourse();
    }

    public CourseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
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
