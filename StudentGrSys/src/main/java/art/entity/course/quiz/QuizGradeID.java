package art.entity.course.quiz;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuizGradeID implements Serializable {

    @Column(name="id_user")
    private Integer idStudent;

    @Column(name="id_quiz")
    private Integer idQuiz;


    public QuizGradeID(){

    }

    public QuizGradeID(Integer idStudent,Integer idQuiz){
        this.idStudent=idStudent;
        this.idQuiz=idQuiz;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Integer idQuiz) {
        this.idQuiz = idQuiz;
    }


    @Override
    public boolean equals(Object o){
        if(this == o ) return true;

        if(o==null || getClass() != o.getClass())
            return false;

        QuizGradeID grade = (QuizGradeID) o;
        return Objects.equals(idStudent,grade.idStudent) && Objects.equals(idQuiz,grade.idQuiz);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(idStudent,idQuiz);
    }

}
