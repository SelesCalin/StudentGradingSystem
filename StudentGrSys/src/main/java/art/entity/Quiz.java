package art.entity;

import art.entity.enumeration.Difficulty;

import javax.persistence.*;

@Entity
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_quiz")
    private Integer idQuiz;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_course")
    private Course course;

    @Column(name="question_nr")
    private Integer questionNumber;


    @Enumerated(EnumType.ORDINAL)
    @Column(name="difficulty")
    private Difficulty difficulty;

    @Column(name="time")
    private Integer time;


    public Quiz() {
    }

    public Quiz(String name, String description, Course course, Integer questionNumber, Difficulty difficulty, Integer time) {
        this.name = name;
        this.description = description;
        this.course = course;
        this.questionNumber = questionNumber;
        this.difficulty = difficulty;
        this.time = time;
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
}
