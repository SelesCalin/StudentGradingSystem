package art.entity;


import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_course")
    private Integer idCourse;


    @Column(name="name")
    private String name;


    @Column(name="description")
    private String description;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_teacher")
    private User teacher;


    @Column(name="enrollkey")
    private String enrollmentKey;

    public Course() {
    }

    public Course(String name, String description, User teacher, String enrollmentKey) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.enrollmentKey = enrollmentKey;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
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

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getEnrollmentKey() {
        return enrollmentKey;
    }

    public void setEnrollmentKey(String enrollmentKey) {
        this.enrollmentKey = enrollmentKey;
    }
}


