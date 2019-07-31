package com.student.gradingSystem.entity.course.assignment;



import com.student.gradingSystem.entity.User;
import com.student.gradingSystem.entity.course.Course;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="assignment")
@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
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


    @OneToMany(
            mappedBy = "assignment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AssignmentGrade> gradeList = new ArrayList<>();


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

    public List<AssignmentGrade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<AssignmentGrade> gradeList) {
        this.gradeList = gradeList;
    }

    public void addGrade(User user, Double grade, String obs) {
        AssignmentGrade assignmentGrade=new AssignmentGrade(user,this,grade,obs);
        gradeList.add(assignmentGrade);
    }

    public void removeGrade(User user) {
      for(Iterator<AssignmentGrade> iterator = gradeList.iterator();iterator.hasNext();) {
          AssignmentGrade assignmentGrade = iterator.next();

          if (assignmentGrade.getAssignment().equals(this) && assignmentGrade.getUser().equals(user)) {
              iterator.remove();
              assignmentGrade.setAssignment(null);
              assignmentGrade.setUser(null);
          }
      }

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
