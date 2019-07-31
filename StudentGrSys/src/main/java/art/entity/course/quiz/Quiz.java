package art.entity.course.quiz;

import art.entity.course.Course;
import art.entity.enumeration.Difficulty;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_quiz")
    private Integer idQuiz;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    @Column(name = "question_nr")
    private Integer questionNumber;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "time")
    private Integer time;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions = new HashSet<Question>();

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizGrade> quizGrades = new ArrayList<>();


    public Quiz() {
    }

    public Quiz(String name, String description, Course course, Integer questionNumber, Difficulty difficulty, Integer time, Set<Question> questions) {
        this.name = name;
        this.description = description;
        this.course = course;
        this.questionNumber = questionNumber;
        this.difficulty = difficulty;
        this.time = time;
        this.questions = questions;
    }

    public Integer getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Integer idQuiz) {
        this.idQuiz = idQuiz;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public List<QuizGrade> getQuizGrades() {
        return quizGrades;
    }

    public void setQuizGrades(List<QuizGrade> quizGrades) {
        this.quizGrades = quizGrades;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setQuiz(this);
    }


    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setQuiz(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;
        return idQuiz != null && idQuiz.equals(((Quiz) o).getIdQuiz());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idQuiz);
    }
}