package com.spring.ex.entity.course.assignment;



import com.spring.ex.entity.User;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="AssignmentGrade")
@Table(name="student_grade")
public class AssignmentGrade {

    @EmbeddedId
    private AssignmentGradeID assignmentGradeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id",nullable = false)
    @MapsId("idStudent")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="assignment_id",nullable = false)
    @MapsId("idAssignment")
    private Assignment assignment;

    @Column(name="grade")
    private Double grade;


    @Column(name="observations")
    private String observations;

    public AssignmentGrade() {
    }

    public AssignmentGrade(User user, Assignment assignment, Double grade, String observations) {
        this.user = user;
        this.assignment = assignment;
        this.grade = grade;
        this.observations = observations;
        this.assignmentGradeID = new AssignmentGradeID(user.getIduser(),assignment.getIdAssignment());
    }

    public AssignmentGradeID getAssignmentGradeID() {
        return assignmentGradeID;
    }

    public void setAssignmentGradeID(AssignmentGradeID assignmentGradeID) {
        this.assignmentGradeID = assignmentGradeID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AssignmentGrade grade = (AssignmentGrade) o;
        return Objects.equals(user, grade.user) &&
                Objects.equals(assignment, grade.assignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user,assignment);
    }
}
