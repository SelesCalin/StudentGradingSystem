package art.entity.course.quiz;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="quiz_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_quiz_question")
    private Integer idQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_quiz")
    private Quiz quiz;

    @Column(name="answer_no")
    private Integer answerNumber;

    @Column(name="question_text")
    private String text;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Answer> answers=new HashSet<Answer>();


    public Question(Quiz quiz, Integer answerNumber, String text, Set<Answer> answers) {
        this.quiz = quiz;
        this.answerNumber = answerNumber;
        this.text = text;
        this.answers=answers;
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

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
        answer.setQuestion(this);
    }


    public void removeAnswer(Answer answer)
    {
        answers.remove(answer);
        answer.setQuestion(null);
    }


}
