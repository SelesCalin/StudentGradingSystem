package art.entity.course;


import art.entity.course.assignment.Assignment;
import art.entity.course.material.Material;
import art.entity.course.quiz.Quiz;
import art.entity.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_course")
    private Integer idCourse;


    @Column(name="name")
    private String name;


    @Column(name="description")
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_teacher")
    private User teacher;


    @Column(name="enrollkey")
    private String enrollmentKey;


    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Assignment> assignments=new HashSet<Assignment>();


    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Material> materials=new HashSet<Material>();

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Quiz> quizzes=new HashSet<Quiz>();


    @ManyToMany(mappedBy = "courses")
    private Set<User> students = new HashSet<>();

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

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public void addAssignment(Assignment assignment){
        assignments.add(assignment);
        assignment.setCourse(this);
    }


    public void removeAssignment(Assignment assignment)
    {
        assignments.remove(assignment);
        assignment.setCourse(null);
    }

    public void addMaterial(Material material){
        materials.add(material);
        material.setCourse(this);
    }


    public void removeMaterial(Material material)
    {
        materials.remove(material);
        material.setCourse(null);
    }


    public void addQuiz(Quiz quiz){
        quizzes.add(quiz);
        quiz.setCourse(this);
    }

    public void removeQuiz(Quiz quiz){
        quizzes.remove(quiz);
        quiz.setCourse(null);
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}


