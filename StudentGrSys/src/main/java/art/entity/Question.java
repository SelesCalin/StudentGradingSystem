package art.entity;


import javax.persistence.*;

@Entity
@Table(name="quiz_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="iq_quiz_question")
    private Integer idQuestion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_quiz")
    private Quiz quiz;

    @Column(name="answer_no")
    private Integer answerNumber;

    @Column(name="question_text")
    private String text;


    public Question(Quiz quiz, Integer answerNumber, String text) {
        this.quiz = quiz;
        this.answerNumber = answerNumber;
        this.text = text;
    }

    public Question() {
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
