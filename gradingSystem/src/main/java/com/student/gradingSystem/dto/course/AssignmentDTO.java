package com.student.gradingSystem.dto.course;

import com.student.gradingSystem.domain.entity.course.assignment.Assignment;

import java.io.Serializable;
import java.sql.Timestamp;

public class AssignmentDTO implements Serializable {
    private Integer id;
    private String name;
    private Timestamp deadline;
    private Double grade;
    private String observations;
    private boolean open;


    public AssignmentDTO(Integer id, String name, Timestamp deadline, Double grade, String observations,boolean open) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.grade = grade;
        this.observations = observations;
        this.open=open;
    }

    public AssignmentDTO() {
    }

    public AssignmentDTO(Assignment assignment){
        this.id=assignment.getIdAssignment();
        this.name=assignment.getName();
        this.deadline=assignment.getDeadline();
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

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
