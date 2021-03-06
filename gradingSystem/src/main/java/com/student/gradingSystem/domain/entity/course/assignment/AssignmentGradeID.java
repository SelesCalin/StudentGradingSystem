package com.student.gradingSystem.domain.entity.course.assignment;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssignmentGradeID implements Serializable {
    @Column(name= "student_id")
    private Integer idStudent;

    @Column(name="assignment_id")
    private Integer idAssignment;

    private AssignmentGradeID() {
    }

    public AssignmentGradeID(Integer idStudent, Integer idAssignment) {
        this.idStudent = idStudent;
        this.idAssignment = idAssignment;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public Integer getIdAssignment() {
        return idAssignment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AssignmentGradeID gradeID = (AssignmentGradeID) o;
        return Objects.equals(idStudent, gradeID.idStudent) &&
                Objects.equals(idAssignment, gradeID.idAssignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent,idAssignment);
    }
}
