package com.student.gradingSystem.dto.course;

import com.student.gradingSystem.domain.entity.course.Course;
import com.student.gradingSystem.domain.entity.course.assignment.Assignment;
import com.student.gradingSystem.dto.user.ProfileDTO;

import java.io.Serializable;
import java.util.List;

public class CourseInfoDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private ProfileDTO teacher;
    private List<AssignmentDTO> assignments;
    private List<QuizInfoDTO> quizzes;

    public CourseInfoDTO(Integer id, String name, String description, ProfileDTO teacher, List<AssignmentDTO> assignments, List<QuizInfoDTO> quizzes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.assignments = assignments;
        this.quizzes = quizzes;
    }

    public CourseInfoDTO() {
    }

    public CourseInfoDTO(Course course){
        this.id=course.getIdCourse();
        this.name=course.getName();
        this.description=course.getDescription();
        this.teacher=new ProfileDTO(course.getTeacher());


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ProfileDTO getTeacher() {
        return teacher;
    }

    public void setTeacherName(ProfileDTO teacher) {
        this.teacher = teacher;
    }

    public List<AssignmentDTO> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentDTO> assignments) {
        this.assignments = assignments;
    }

    public List<QuizInfoDTO> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<QuizInfoDTO> quizzes) {
        this.quizzes = quizzes;
    }
}
