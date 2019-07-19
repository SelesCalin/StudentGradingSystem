package art.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="assignment")
public class Assignment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_assignment")
    private Integer idAssignment;


    @Column(name="name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_course")
    private Course course;

    @Column(name="deadline")
    private Timestamp deadline;

    public Assignment(String name, Course course, Timestamp deadline) {
        this.name = name;
        this.course = course;
        this.deadline = deadline;
    }

    public Assignment() {
    }

    public Integer getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(Integer idAssignment) {
        this.idAssignment = idAssignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment )) return false;
        return idAssignment != null && idAssignment.equals(((Assignment) o).getIdAssignment());
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(idAssignment);
    }
}
