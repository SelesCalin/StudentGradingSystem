package com.student.gradingSystem.dto.course;

import com.student.gradingSystem.domain.entity.course.quiz.Quiz;

import java.io.Serializable;

public class QuizInfoDTO implements Serializable {
    private Integer id;
    private String name;
    private String difficulty;
    private String description;
    private boolean taken;
    private Double grade;

    public QuizInfoDTO(Integer id, String name, String difficulty, String description, boolean taken, Double grade) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.description = description;
        this.taken = taken;
        this.grade = grade;
    }

    public QuizInfoDTO() {
    }

    public QuizInfoDTO(Quiz quiz){
        this.id=quiz.getIdQuiz();
        this.name=quiz.getName();
        this.difficulty=quiz.getDifficulty().toString();
        this.description=quiz.getDescription();

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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
