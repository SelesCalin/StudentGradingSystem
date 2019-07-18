package art.entity;


import art.entity.enumeration.ResponseType;

import javax.persistence.*;

@Entity
@Table(name= "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_answer")
    private Integer idAnswer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_question")
    private Question question;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="good")
    private ResponseType correct;

    @Column(name="text")
    private String text;

    public Answer() {
    }

    public Answer(Question question, ResponseType correct, String text) {
        this.question = question;
        this.correct = correct;
        this.text = text;
    }

    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ResponseType getCorrect() {
        return correct;
    }

    public void setCorrect(ResponseType correct) {
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
