package com.student.gradingSystem.domain.entity.course.quiz;

import com.student.gradingSystem.domain.entity.User;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="QuizGrade")
@Table(name="quiz_grade")
public class QuizGrade {
    @EmbeddedId
    private QuizGradeID quizGradeID;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_user",nullable = false)
    @MapsId("idStudent")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_quiz",nullable = false)
    @MapsId("idQuiz")
    private Quiz quiz;

    @Column(name="grade")
    private Double grade;

    public QuizGrade(){
    }

    public QuizGrade(User user,Quiz quiz,Double grade){
        this.user=user;
        this.quiz=quiz;
        this.grade=grade;
        this.quizGradeID=new QuizGradeID(user.getIduser(),quiz.getIdQuiz());
    }

    public QuizGradeID getQuizGradeID() {
        return quizGradeID;
    }

    public void setQuizGradeID(QuizGradeID quizGradeID) {
        this.quizGradeID = quizGradeID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        QuizGrade grade = (QuizGrade) o;
        return Objects.equals(user, grade.user) &&
                Objects.equals(quiz, grade.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user,quiz);
    }
}
